package com.androidteam.mvi

import com.androidteam.presentacion.state.LDillonReduceAction
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.scan
import kotlinx.coroutines.launch

class MviStoreEffect<S : ViewState, I : ViewIntent, A : ReduceAction, E : ViewSideEffect>(
    initialState: S,
    private val scope: CoroutineScope = CoroutineScope(SupervisorJob()),
    private val reducer: Reducer<S, A> = Reducer { currentState, _ -> currentState },
    val sideEffect: SideEffect<S, A, E>? = null,
    private val middlewares: List<MiddlewareEffect<S, I, A, E>> = emptyList()
) : StoreEffect<S, I, A, E> {
    private val internalState = MutableStateFlow(initialState)
    override val state: StateFlow<S> = internalState.asStateFlow()

    private val internalSideEffects: Channel<E> = Channel()
    private var previousExecutedSideEffect: ViewSideEffect? = null
    override val sideEffects: Flow<E> = internalSideEffects.receiveAsFlow()

    private val intents = MutableSharedFlow<I>(extraBufferCapacity = 64)
    private val actions = MutableSharedFlow<A>(extraBufferCapacity = 64)
    private val effects = MutableSharedFlow<E>(extraBufferCapacity = 64)

    init {
        intents
            .onEach { intent ->
                middlewares.forEach { middleware ->
                    scope.launch {
                        middleware.process(
                            intent,
                            internalState::value,
                            effects::emit,
                            actions::emit
                        )
                    }
                }
            }
            .launchIn(scope)

        effects.onEach { effect ->
            sendSideEffect { effect }
            delay(SIDE_EFFECT_DELAY)
        }.launchIn(scope)

        actions
            .scan(initialState) { currentState, action ->
                val newState = reducer.reduce(currentState, action)
                val newSideEffect = sideEffect?.sideEffect(newState, action)

                // TODO: Pablo please check this
                if (newSideEffect != null) {
                    sendSideEffect {
                        newSideEffect
                    }
                }
                previousExecutedSideEffect = newSideEffect
                newState
            }
            .onEach { newState ->
                // discard new state if it is the same as the current state
                if (newState != internalState.value) {
                    internalState.value = newState
                }
            }
            .launchIn(scope)
    }

    override fun onIntent(intent: I) {
        intents.tryEmit(intent)
    }

    private fun sendSideEffect(builder: () -> E) {
        val effectValue = builder()
        scope.launch { internalSideEffects.send(effectValue) }
    }

    companion object {
        private const val SIDE_EFFECT_DELAY = 10L
    }
}
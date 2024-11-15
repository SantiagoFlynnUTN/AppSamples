package com.androidteam.mvi

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.scan
import kotlinx.coroutines.launch

class MviStore<S : ViewState, I : ViewIntent, A : ReduceAction>(
    initialState: S,
    val scope: CoroutineScope = CoroutineScope(SupervisorJob()),
    private val reducer: Reducer<S, A> = Reducer { currentState, _ -> currentState },
    private val middlewares: List<Middleware<S, I, A>> = emptyList()
) : Store<S, I, A> {
    private val internalState = MutableStateFlow(initialState)
    override val state: StateFlow<S> = internalState.asStateFlow()

    private val intents = MutableSharedFlow<I>(extraBufferCapacity = 64)
    private val actions = MutableSharedFlow<A>(extraBufferCapacity = 64)

    init {
        intents
            .onEach { intent ->
                middlewares.forEach { middleware ->
                    scope.launch {
                        middleware.process(
                            intent,
                            internalState::value,
                            actions::emit
                        )
                    }
                }
            }
            .launchIn(scope)

        actions
            .scan(initialState) { currentState, action ->
                reducer.reduce(currentState, action)
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
}
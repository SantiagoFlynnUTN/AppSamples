package com.androidteam.presentacion.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.androidteam.mvi.MviStoreEffect
import com.androidteam.mvi.StoreEffect
import com.androidteam.presentacion.middleware.LDillonMiddleware
import com.androidteam.presentacion.reducer.LDillonReducer
import com.androidteam.presentacion.state.LDillonReduceAction
import com.androidteam.presentacion.state.LDillonSideEffect
import com.androidteam.presentacion.state.LDillonViewIntent
import com.androidteam.presentacion.state.LDillonViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject


@HiltViewModel
class LDillonViewModel @Inject constructor(

) : ViewModel(),
    StoreEffect<
        LDillonViewState,
        LDillonViewIntent,
        LDillonReduceAction,
        LDillonSideEffect
    > {
    private val store = MviStoreEffect(
        initialState =  LDillonViewState(),
        scope = viewModelScope,
        reducer = LDillonReducer(),
        sideEffect = com.androidteam.presentacion.effect.LDillonSideEffect(),
        middlewares = listOf(
            LDillonMiddleware(

            )
        )

    )
    override val state: StateFlow<LDillonViewState> = store.state
    override val sideEffects: Flow<LDillonSideEffect> = store.sideEffects
    override fun onIntent(intent: LDillonViewIntent) {
        store.onIntent(intent)
    }

}

package com.androidteam.mvi

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface StoreEffect<S : ViewState, I : ViewIntent, A : ReduceAction, E : ViewSideEffect> {
    val state: StateFlow<S>
    val sideEffects: Flow<E>
    fun onIntent(intent: I)
}
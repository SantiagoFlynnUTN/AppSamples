package com.androidteam.mvi

fun interface MiddlewareEffect<S : ViewState, I : ViewIntent, A : ReduceAction, E : ViewSideEffect> {
    suspend fun process(
        intent: I,
        currentState: () -> S,
        dispatchEffect: suspend (E) -> Unit,
        dispatch: suspend (A) -> Unit
    )
}
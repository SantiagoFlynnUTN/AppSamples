package com.androidteam.mvi

fun interface Middleware<S : ViewState, I : ViewIntent, A : ReduceAction> {
    suspend fun process(intent: I, currentState: () -> S, dispatch: suspend (A) -> Unit)
}
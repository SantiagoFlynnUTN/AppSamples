package com.androidteam.mvi

fun interface SideEffect<S : ViewState, A : ReduceAction, E : ViewSideEffect> {
    fun sideEffect(currentState: S, action: A): E?
}
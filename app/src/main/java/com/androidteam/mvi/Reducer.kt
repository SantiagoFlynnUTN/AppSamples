package com.androidteam.mvi

fun interface Reducer<S : ViewState, A : ReduceAction> {
    fun reduce(currentState: S, action: A): S
}
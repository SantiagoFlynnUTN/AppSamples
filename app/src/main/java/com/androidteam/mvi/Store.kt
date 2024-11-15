package com.androidteam.mvi

import kotlinx.coroutines.flow.StateFlow

interface Store<S : ViewState, I : ViewIntent, A : ReduceAction> {
    /**
     * Represents the current state of the UI
     */
    val state: StateFlow<S>

    /**
     * Called when an event is triggered, like a button click, etc.
     */
    fun onIntent(intent: I)
}
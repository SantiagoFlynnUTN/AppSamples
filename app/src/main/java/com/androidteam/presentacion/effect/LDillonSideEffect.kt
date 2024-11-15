package com.androidteam.presentacion.effect

import com.androidteam.mvi.SideEffect
import com.androidteam.presentacion.state.LDillonReduceAction
import com.androidteam.presentacion.state.LDillonSideEffect
import com.androidteam.presentacion.state.LDillonViewState

class LDillonSideEffect: SideEffect <LDillonViewState, LDillonReduceAction, LDillonSideEffect > {
    override fun sideEffect(
        currentState: LDillonViewState,
        action: LDillonReduceAction
    ): LDillonSideEffect? {
        TODO("Not yet implemented")
    }
}
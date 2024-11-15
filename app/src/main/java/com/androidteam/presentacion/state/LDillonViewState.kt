package com.androidteam.presentacion.state

import com.androidteam.mvi.ReduceAction
import com.androidteam.mvi.SideEffect
import com.androidteam.mvi.ViewState
import com.androidteam.mvi.ViewIntent
import com.androidteam.mvi.ViewSideEffect

data class LDillonViewState(
    val datosTraidos: String = ""
) : ViewState

sealed class LDillonViewIntent : ViewIntent {

    data class processInfoClicked(val datos: String) : LDillonViewIntent()
    data object clearDataClicked : LDillonViewIntent()
}

sealed class LDillonReduceAction : ReduceAction {
    data class datosTraidosChanged(val datos: String) : LDillonReduceAction()
}

sealed class LDillonSideEffect : ViewSideEffect {

}


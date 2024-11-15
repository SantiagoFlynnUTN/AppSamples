package com.androidteam.presentacion.reducer

import com.androidteam.mvi.Reducer
import com.androidteam.presentacion.state.LDillonReduceAction
import com.androidteam.presentacion.state.LDillonViewState

class LDillonReducer : Reducer<LDillonViewState, LDillonReduceAction> {
    override fun reduce( currentState: LDillonViewState, action: LDillonReduceAction): LDillonViewState {
         return when (action) {
             is LDillonReduceAction.datosTraidosChanged -> {
                 currentState.copy(datosTraidos = action.datos)
             }
         }
    }
}
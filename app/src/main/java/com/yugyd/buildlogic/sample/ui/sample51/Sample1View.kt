package com.yugyd.buildlogic.sample.ui.sample51

interface Sample51View {

    data class State(
        val isLoading: Boolean = false,
        val isError: Boolean = false,
        val title: String = "",
    )
}
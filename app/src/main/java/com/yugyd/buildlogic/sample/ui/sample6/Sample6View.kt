package com.yugyd.buildlogic.sample.ui.sample6

interface Sample6View {

    data class State(
        val isLoading: Boolean = false,
        val isError: Boolean = false,
        val title: String = "",
    )
}
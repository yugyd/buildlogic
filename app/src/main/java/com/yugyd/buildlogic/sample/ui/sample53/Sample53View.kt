package com.yugyd.buildlogic.sample.ui.sample53

interface Sample53View {

    data class State(
        val isLoading: Boolean = false,
        val isError: Boolean = false,
        val title: String = "",
    )
}
package com.yugyd.buildlogic.sample.ui.sample35

interface Sample35View {

    data class State(
        val isLoading: Boolean = false,
        val isError: Boolean = false,
        val title: String = "",
    )
}
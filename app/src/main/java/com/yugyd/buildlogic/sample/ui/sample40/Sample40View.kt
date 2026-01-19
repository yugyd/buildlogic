package com.yugyd.buildlogic.sample.ui.sample40

interface Sample40View {

    data class State(
        val isLoading: Boolean = false,
        val isError: Boolean = false,
        val title: String = "",
    )
}
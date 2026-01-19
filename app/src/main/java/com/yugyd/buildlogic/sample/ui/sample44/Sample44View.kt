package com.yugyd.buildlogic.sample.ui.sample44

interface Sample44View {

    data class State(
        val isLoading: Boolean = false,
        val isError: Boolean = false,
        val title: String = "",
    )
}
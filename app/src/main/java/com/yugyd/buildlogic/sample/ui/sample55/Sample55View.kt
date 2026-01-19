package com.yugyd.buildlogic.sample.ui.sample55

interface Sample55View {

    data class State(
        val isLoading: Boolean = false,
        val isError: Boolean = false,
        val title: String = "",
    )
}
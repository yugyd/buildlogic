package com.yugyd.buildlogic.sample.ui.sample25

interface Sample25View {

    data class State(
        val isLoading: Boolean = false,
        val isError: Boolean = false,
        val title: String = "",
    )
}
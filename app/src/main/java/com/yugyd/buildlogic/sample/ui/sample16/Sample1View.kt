package com.yugyd.buildlogic.sample.ui.sample16

interface Sample16View {

    data class State(
        val isLoading: Boolean = false,
        val isError: Boolean = false,
        val title: String = "",
    )
}
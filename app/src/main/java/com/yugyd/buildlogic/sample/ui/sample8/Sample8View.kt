package com.yugyd.buildlogic.sample.ui.sample8

interface Sample8View {

    data class State(
        val isLoading: Boolean = false,
        val isError: Boolean = false,
        val title: String = "",
    )
}
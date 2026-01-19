package com.yugyd.buildlogic.sample.ui.sample30

interface Sample30View {

    data class State(
        val isLoading: Boolean = false,
        val isError: Boolean = false,
        val title: String = "",
    )
}
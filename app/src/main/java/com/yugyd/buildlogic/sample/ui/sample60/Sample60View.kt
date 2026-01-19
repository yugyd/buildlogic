package com.yugyd.buildlogic.sample.ui.sample60

interface Sample60View {

    data class State(
        val isLoading: Boolean = false,
        val isError: Boolean = false,
        val title: String = "",
    )
}
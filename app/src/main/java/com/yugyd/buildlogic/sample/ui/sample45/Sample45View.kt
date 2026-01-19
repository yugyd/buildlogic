package com.yugyd.buildlogic.sample.ui.sample45

interface Sample45View {

    data class State(
        val isLoading: Boolean = false,
        val isError: Boolean = false,
        val title: String = "",
    )
}
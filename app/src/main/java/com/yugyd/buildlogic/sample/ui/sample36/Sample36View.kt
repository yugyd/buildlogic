package com.yugyd.buildlogic.sample.ui.sample36

interface Sample36View {

    data class State(
        val isLoading: Boolean = false,
        val isError: Boolean = false,
        val title: String = "",
    )
}
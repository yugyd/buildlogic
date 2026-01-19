package com.yugyd.buildlogic.sample.ui.sample33

interface Sample33View {

    data class State(
        val isLoading: Boolean = false,
        val isError: Boolean = false,
        val title: String = "",
    )
}
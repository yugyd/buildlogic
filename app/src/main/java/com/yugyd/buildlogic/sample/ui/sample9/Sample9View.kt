package com.yugyd.buildlogic.sample.ui.sample9

interface Sample9View {

    data class State(
        val isLoading: Boolean = false,
        val isError: Boolean = false,
        val title: String = "",
    )
}
package com.yugyd.buildlogic.sample.ui.sample50

interface Sample50View {

    data class State(
        val isLoading: Boolean = false,
        val isError: Boolean = false,
        val title: String = "",
    )
}
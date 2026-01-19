package com.yugyd.buildlogic.sample.ui.sample58

interface Sample58View {

    data class State(
        val isLoading: Boolean = false,
        val isError: Boolean = false,
        val title: String = "",
    )
}
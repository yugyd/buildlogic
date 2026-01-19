package com.yugyd.buildlogic.sample.ui.sample52

interface Sample52View {

    data class State(
        val isLoading: Boolean = false,
        val isError: Boolean = false,
        val title: String = "",
    )
}
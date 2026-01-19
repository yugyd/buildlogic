package com.yugyd.buildlogic.sample.ui.sample38

interface Sample38View {

    data class State(
        val isLoading: Boolean = false,
        val isError: Boolean = false,
        val title: String = "",
    )
}
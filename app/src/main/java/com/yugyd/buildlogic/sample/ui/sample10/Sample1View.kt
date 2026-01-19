package com.yugyd.buildlogic.sample.ui.sample10

interface Sample10View {

    data class State(
        val isLoading: Boolean = false,
        val isError: Boolean = false,
        val title: String = "",
    )
}
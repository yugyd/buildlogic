package com.yugyd.buildlogic.sample.ui.sample13

interface Sample13View {

    data class State(
        val isLoading: Boolean = false,
        val isError: Boolean = false,
        val title: String = "",
    )
}
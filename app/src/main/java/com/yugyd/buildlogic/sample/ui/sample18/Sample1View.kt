package com.yugyd.buildlogic.sample.ui.sample18

interface Sample18View {

    data class State(
        val isLoading: Boolean = false,
        val isError: Boolean = false,
        val title: String = "",
    )
}
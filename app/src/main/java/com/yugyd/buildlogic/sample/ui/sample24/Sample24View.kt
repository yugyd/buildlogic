package com.yugyd.buildlogic.sample.ui.sample24

interface Sample24View {

    data class State(
        val isLoading: Boolean = false,
        val isError: Boolean = false,
        val title: String = "",
    )
}
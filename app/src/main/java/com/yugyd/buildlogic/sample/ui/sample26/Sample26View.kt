package com.yugyd.buildlogic.sample.ui.sample26

interface Sample26View {

    data class State(
        val isLoading: Boolean = false,
        val isError: Boolean = false,
        val title: String = "",
    )
}
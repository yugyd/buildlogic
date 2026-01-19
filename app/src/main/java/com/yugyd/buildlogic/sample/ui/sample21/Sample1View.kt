package com.yugyd.buildlogic.sample.ui.sample21

interface Sample21View {

    data class State(
        val isLoading: Boolean = false,
        val isError: Boolean = false,
        val title: String = "",
    )
}
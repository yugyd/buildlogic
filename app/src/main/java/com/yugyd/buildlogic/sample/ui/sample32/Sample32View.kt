package com.yugyd.buildlogic.sample.ui.sample32

interface Sample32View {

    data class State(
        val isLoading: Boolean = false,
        val isError: Boolean = false,
        val title: String = "",
    )
}
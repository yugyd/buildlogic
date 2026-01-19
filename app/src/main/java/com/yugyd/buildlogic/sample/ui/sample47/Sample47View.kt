package com.yugyd.buildlogic.sample.ui.sample47

interface Sample47View {

    data class State(
        val isLoading: Boolean = false,
        val isError: Boolean = false,
        val title: String = "",
    )
}
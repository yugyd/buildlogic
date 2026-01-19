package com.yugyd.buildlogic.sample.ui.sample28

interface Sample28View {

    data class State(
        val isLoading: Boolean = false,
        val isError: Boolean = false,
        val title: String = "",
    )
}
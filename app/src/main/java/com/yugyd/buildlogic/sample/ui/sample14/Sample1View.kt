package com.yugyd.buildlogic.sample.ui.sample14

interface Sample14View {

    data class State(
        val isLoading: Boolean = false,
        val isError: Boolean = false,
        val title: String = "",
    )
}
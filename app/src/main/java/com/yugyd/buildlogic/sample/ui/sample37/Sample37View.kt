package com.yugyd.buildlogic.sample.ui.sample37

interface Sample37View {

    data class State(
        val isLoading: Boolean = false,
        val isError: Boolean = false,
        val title: String = "",
    )
}
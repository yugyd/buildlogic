package com.yugyd.buildlogic.sample.ui.sample27

interface Sample27View {

    data class State(
        val isLoading: Boolean = false,
        val isError: Boolean = false,
        val title: String = "",
    )
}
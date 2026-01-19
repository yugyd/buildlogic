package com.yugyd.buildlogic.sample.ui.sample49

interface Sample49View {

    data class State(
        val isLoading: Boolean = false,
        val isError: Boolean = false,
        val title: String = "",
    )
}
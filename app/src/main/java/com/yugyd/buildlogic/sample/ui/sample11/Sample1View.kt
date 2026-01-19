package com.yugyd.buildlogic.sample.ui.sample11

interface Sample11View {

    data class State(
        val isLoading: Boolean = false,
        val isError: Boolean = false,
        val title: String = "",
    )
}
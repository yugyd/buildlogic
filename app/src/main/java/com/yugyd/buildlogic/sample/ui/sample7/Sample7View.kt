package com.yugyd.buildlogic.sample.ui.sample7

interface Sample7View {

    data class State(
        val isLoading: Boolean = false,
        val isError: Boolean = false,
        val title: String = "",
    )
}
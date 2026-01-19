package com.yugyd.buildlogic.sample.ui.sample59

interface Sample59View {

    data class State(
        val isLoading: Boolean = false,
        val isError: Boolean = false,
        val title: String = "",
    )
}
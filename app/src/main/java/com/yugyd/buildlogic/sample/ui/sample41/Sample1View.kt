package com.yugyd.buildlogic.sample.ui.sample41

interface Sample41View {

    data class State(
        val isLoading: Boolean = false,
        val isError: Boolean = false,
        val title: String = "",
    )
}
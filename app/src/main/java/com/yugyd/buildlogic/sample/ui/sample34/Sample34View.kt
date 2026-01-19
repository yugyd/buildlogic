package com.yugyd.buildlogic.sample.ui.sample34

interface Sample34View {

    data class State(
        val isLoading: Boolean = false,
        val isError: Boolean = false,
        val title: String = "",
    )
}
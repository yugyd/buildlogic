package com.yugyd.buildlogic.sample.data.sample7

import kotlinx.coroutines.flow.flow

class Sample7RepositoryImpl : Sample7Repository {
    override fun getData() = flow {
        emit("Sample7")
    }
}

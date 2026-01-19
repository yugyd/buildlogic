package com.yugyd.buildlogic.sample.data.sample8

import kotlinx.coroutines.flow.flow

class Sample8RepositoryImpl : Sample8Repository {
    override fun getData() = flow {
        emit("Sample8")
    }
}

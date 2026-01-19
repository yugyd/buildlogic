package com.yugyd.buildlogic.sample.data.sample4

import kotlinx.coroutines.flow.flow

class Sample4RepositoryImpl : Sample4Repository {
    override fun getData() = flow {
        emit("Sample4")
    }
}

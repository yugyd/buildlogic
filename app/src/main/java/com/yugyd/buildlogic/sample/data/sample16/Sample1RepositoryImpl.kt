package com.yugyd.buildlogic.sample.data.sample16

import kotlinx.coroutines.flow.flow

class Sample16RepositoryImpl :
    Sample16Repository {
    override fun getData() = flow {
        emit("Sample16")
    }
}

package com.yugyd.buildlogic.sample.data.sample44

import kotlinx.coroutines.flow.flow

class Sample44RepositoryImpl :
    Sample44Repository {
    override fun getData() = flow {
        emit("Sample44")
    }
}

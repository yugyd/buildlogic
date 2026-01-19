package com.yugyd.buildlogic.sample.data.sample45

import kotlinx.coroutines.flow.flow

class Sample45RepositoryImpl :
    Sample45Repository {
    override fun getData() = flow {
        emit("Sample45")
    }
}

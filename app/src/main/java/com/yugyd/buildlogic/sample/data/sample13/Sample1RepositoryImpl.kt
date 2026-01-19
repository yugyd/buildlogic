package com.yugyd.buildlogic.sample.data.sample13

import kotlinx.coroutines.flow.flow

class Sample13RepositoryImpl :
    Sample13Repository {
    override fun getData() = flow {
        emit("Sample13")
    }
}

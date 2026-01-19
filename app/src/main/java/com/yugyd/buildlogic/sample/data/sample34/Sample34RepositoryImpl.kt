package com.yugyd.buildlogic.sample.data.sample34

import kotlinx.coroutines.flow.flow

class Sample34RepositoryImpl :
    Sample34Repository {
    override fun getData() = flow {
        emit("Sample34")
    }
}

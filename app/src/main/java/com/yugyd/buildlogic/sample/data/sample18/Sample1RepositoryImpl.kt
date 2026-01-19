package com.yugyd.buildlogic.sample.data.sample18

import kotlinx.coroutines.flow.flow

class Sample18RepositoryImpl :
    Sample18Repository {
    override fun getData() = flow {
        emit("Sample18")
    }
}

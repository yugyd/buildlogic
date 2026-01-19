package com.yugyd.buildlogic.sample.data.sample21

import kotlinx.coroutines.flow.flow

class Sample21RepositoryImpl :
    Sample21Repository {
    override fun getData() = flow {
        emit("Sample21")
    }
}

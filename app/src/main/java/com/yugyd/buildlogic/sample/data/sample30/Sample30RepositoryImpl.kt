package com.yugyd.buildlogic.sample.data.sample30

import kotlinx.coroutines.flow.flow

class Sample30RepositoryImpl :
    Sample30Repository {
    override fun getData() = flow {
        emit("Sample30")
    }
}

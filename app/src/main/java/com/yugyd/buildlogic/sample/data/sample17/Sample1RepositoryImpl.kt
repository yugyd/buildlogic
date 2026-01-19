package com.yugyd.buildlogic.sample.data.sample17

import kotlinx.coroutines.flow.flow

class Sample17RepositoryImpl :
    Sample17Repository {
    override fun getData() = flow {
        emit("Sample17")
    }
}

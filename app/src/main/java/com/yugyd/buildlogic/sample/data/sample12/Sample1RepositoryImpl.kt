package com.yugyd.buildlogic.sample.data.sample12

import kotlinx.coroutines.flow.flow

class Sample12RepositoryImpl :
    Sample12Repository {
    override fun getData() = flow {
        emit("Sample12")
    }
}

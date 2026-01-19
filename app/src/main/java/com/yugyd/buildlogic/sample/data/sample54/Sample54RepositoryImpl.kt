package com.yugyd.buildlogic.sample.data.sample54

import kotlinx.coroutines.flow.flow

class Sample54RepositoryImpl :
    Sample54Repository {
    override fun getData() = flow {
        emit("Sample54")
    }
}

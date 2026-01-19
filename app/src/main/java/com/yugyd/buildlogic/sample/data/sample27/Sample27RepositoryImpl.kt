package com.yugyd.buildlogic.sample.data.sample27

import kotlinx.coroutines.flow.flow

class Sample27RepositoryImpl :
    Sample27Repository {
    override fun getData() = flow {
        emit("Sample27")
    }
}

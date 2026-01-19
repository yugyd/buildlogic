package com.yugyd.buildlogic.sample.data.sample47

import kotlinx.coroutines.flow.flow

class Sample47RepositoryImpl :
    Sample47Repository {
    override fun getData() = flow {
        emit("Sample47")
    }
}

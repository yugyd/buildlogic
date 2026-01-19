package com.yugyd.buildlogic.sample.data.sample11

import kotlinx.coroutines.flow.flow

class Sample11RepositoryImpl :
    Sample11Repository {
    override fun getData() = flow {
        emit("Sample11")
    }
}

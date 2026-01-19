package com.yugyd.buildlogic.sample.data.sample33

import kotlinx.coroutines.flow.flow

class Sample33RepositoryImpl :
    Sample33Repository {
    override fun getData() = flow {
        emit("Sample33")
    }
}

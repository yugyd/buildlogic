package com.yugyd.buildlogic.sample.data.sample19

import kotlinx.coroutines.flow.flow

class Sample19RepositoryImpl :
    Sample19Repository {
    override fun getData() = flow {
        emit("Sample19")
    }
}

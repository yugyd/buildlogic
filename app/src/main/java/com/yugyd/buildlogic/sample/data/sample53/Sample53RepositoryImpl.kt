package com.yugyd.buildlogic.sample.data.sample53

import kotlinx.coroutines.flow.flow

class Sample53RepositoryImpl :
    Sample53Repository {
    override fun getData() = flow {
        emit("Sample53")
    }
}

package com.yugyd.buildlogic.sample.data.sample22

import kotlinx.coroutines.flow.flow

class Sample22RepositoryImpl :
    Sample22Repository {
    override fun getData() = flow {
        emit("Sample22")
    }
}

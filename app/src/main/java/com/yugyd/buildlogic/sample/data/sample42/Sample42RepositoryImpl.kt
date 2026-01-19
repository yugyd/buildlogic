package com.yugyd.buildlogic.sample.data.sample42

import kotlinx.coroutines.flow.flow

class Sample42RepositoryImpl :
    Sample42Repository {
    override fun getData() = flow {
        emit("Sample42")
    }
}

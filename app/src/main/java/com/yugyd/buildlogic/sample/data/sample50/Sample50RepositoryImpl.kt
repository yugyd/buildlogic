package com.yugyd.buildlogic.sample.data.sample50

import kotlinx.coroutines.flow.flow

class Sample50RepositoryImpl :
    Sample50Repository {
    override fun getData() = flow {
        emit("Sample50")
    }
}

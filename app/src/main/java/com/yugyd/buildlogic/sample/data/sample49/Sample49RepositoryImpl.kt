package com.yugyd.buildlogic.sample.data.sample49

import kotlinx.coroutines.flow.flow

class Sample49RepositoryImpl :
    Sample49Repository {
    override fun getData() = flow {
        emit("Sample49")
    }
}

package com.yugyd.buildlogic.sample.data.sample56

import kotlinx.coroutines.flow.flow

class Sample56RepositoryImpl :
    Sample56Repository {
    override fun getData() = flow {
        emit("Sample56")
    }
}

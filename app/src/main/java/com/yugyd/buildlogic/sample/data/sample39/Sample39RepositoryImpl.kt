package com.yugyd.buildlogic.sample.data.sample39

import kotlinx.coroutines.flow.flow

class Sample39RepositoryImpl :
    Sample39Repository {
    override fun getData() = flow {
        emit("Sample39")
    }
}

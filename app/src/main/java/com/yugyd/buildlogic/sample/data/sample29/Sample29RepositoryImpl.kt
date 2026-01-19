package com.yugyd.buildlogic.sample.data.sample29

import kotlinx.coroutines.flow.flow

class Sample29RepositoryImpl :
    Sample29Repository {
    override fun getData() = flow {
        emit("Sample29")
    }
}

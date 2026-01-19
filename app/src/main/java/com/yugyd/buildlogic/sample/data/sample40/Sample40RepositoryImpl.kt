package com.yugyd.buildlogic.sample.data.sample40

import kotlinx.coroutines.flow.flow

class Sample40RepositoryImpl :
    Sample40Repository {
    override fun getData() = flow {
        emit("Sample40")
    }
}

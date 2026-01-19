package com.yugyd.buildlogic.sample.data.sample24

import kotlinx.coroutines.flow.flow

class Sample24RepositoryImpl :
    Sample24Repository {
    override fun getData() = flow {
        emit("Sample24")
    }
}

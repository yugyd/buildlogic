package com.yugyd.buildlogic.sample.data.sample25

import kotlinx.coroutines.flow.flow

class Sample25RepositoryImpl :
    Sample25Repository {
    override fun getData() = flow {
        emit("Sample25")
    }
}

package com.yugyd.buildlogic.sample.data.sample15

import kotlinx.coroutines.flow.flow

class Sample15RepositoryImpl :
    Sample15Repository {
    override fun getData() = flow {
        emit("Sample15")
    }
}

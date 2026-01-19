package com.yugyd.buildlogic.sample.data.sample37

import kotlinx.coroutines.flow.flow

class Sample37RepositoryImpl :
    Sample37Repository {
    override fun getData() = flow {
        emit("Sample37")
    }
}

package com.yugyd.buildlogic.sample.data.sample28

import kotlinx.coroutines.flow.flow

class Sample28RepositoryImpl :
    Sample28Repository {
    override fun getData() = flow {
        emit("Sample28")
    }
}

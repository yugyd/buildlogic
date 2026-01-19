package com.yugyd.buildlogic.sample.data.sample52

import kotlinx.coroutines.flow.flow

class Sample52RepositoryImpl :
    Sample52Repository {
    override fun getData() = flow {
        emit("Sample52")
    }
}

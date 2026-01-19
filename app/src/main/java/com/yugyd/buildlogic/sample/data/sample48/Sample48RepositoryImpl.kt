package com.yugyd.buildlogic.sample.data.sample48

import kotlinx.coroutines.flow.flow

class Sample48RepositoryImpl :
    Sample48Repository {
    override fun getData() = flow {
        emit("Sample48")
    }
}

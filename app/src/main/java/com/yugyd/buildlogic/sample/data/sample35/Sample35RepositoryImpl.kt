package com.yugyd.buildlogic.sample.data.sample35

import kotlinx.coroutines.flow.flow

class Sample35RepositoryImpl :
    Sample35Repository {
    override fun getData() = flow {
        emit("Sample35")
    }
}

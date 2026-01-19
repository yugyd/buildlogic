package com.yugyd.buildlogic.sample.data.sample9

import kotlinx.coroutines.flow.flow

class Sample9RepositoryImpl : Sample9Repository {
    override fun getData() = flow {
        emit("Sample9")
    }
}

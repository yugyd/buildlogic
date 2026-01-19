package com.yugyd.buildlogic.sample.domain.sample50

import com.yugyd.buildlogic.sample.data.sample50.Sample50Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

class Sample50UseCase(
    private val sample50Repository: Sample50Repository,
) {

    operator fun invoke(): Flow<String> {
        return sample50Repository
            .getData()
            .flowOn(Dispatchers.IO)
    }
}

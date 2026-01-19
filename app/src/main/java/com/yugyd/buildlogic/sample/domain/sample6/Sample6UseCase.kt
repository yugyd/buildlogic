package com.yugyd.buildlogic.sample.domain.sample6

import com.yugyd.buildlogic.sample.data.sample6.Sample6Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

class Sample6UseCase(
    private val sample6Repository: Sample6Repository,
) {

    operator fun invoke(): Flow<String> {
        return sample6Repository
            .getData()
            .flowOn(Dispatchers.IO)
    }
}

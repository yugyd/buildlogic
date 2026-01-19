package com.yugyd.buildlogic.sample.domain.sample3

import com.yugyd.buildlogic.sample.data.sample3.Sample3Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

class Sample3UseCase(
    private val sample3Repository: Sample3Repository,
) {

    operator fun invoke(): Flow<String> {
        return sample3Repository
            .getData()
            .flowOn(Dispatchers.IO)
    }
}

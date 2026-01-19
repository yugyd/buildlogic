package com.yugyd.buildlogic.sample.domain.sample41

import com.yugyd.buildlogic.sample.data.sample41.Sample41Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

class Sample41UseCase(
    private val sample41Repository: Sample41Repository,
) {

    operator fun invoke(): Flow<String> {
        return sample41Repository
            .getData()
            .flowOn(Dispatchers.IO)
    }
}

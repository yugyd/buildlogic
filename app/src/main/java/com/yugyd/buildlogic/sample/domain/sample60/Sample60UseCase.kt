package com.yugyd.buildlogic.sample.domain.sample60

import com.yugyd.buildlogic.sample.data.sample60.Sample60Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

class Sample60UseCase(
    private val sample60Repository: Sample60Repository,
) {

    operator fun invoke(): Flow<String> {
        return sample60Repository
            .getData()
            .flowOn(Dispatchers.IO)
    }
}

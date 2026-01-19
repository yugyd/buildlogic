package com.yugyd.buildlogic.sample.domain.sample58

import com.yugyd.buildlogic.sample.data.sample58.Sample58Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

class Sample58UseCase(
    private val sample58Repository: Sample58Repository,
) {

    operator fun invoke(): Flow<String> {
        return sample58Repository
            .getData()
            .flowOn(Dispatchers.IO)
    }
}

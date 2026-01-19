package com.yugyd.buildlogic.sample.domain.sample27

import com.yugyd.buildlogic.sample.data.sample27.Sample27Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

class Sample27UseCase(
    private val sample27Repository: Sample27Repository,
) {

    operator fun invoke(): Flow<String> {
        return sample27Repository
            .getData()
            .flowOn(Dispatchers.IO)
    }
}

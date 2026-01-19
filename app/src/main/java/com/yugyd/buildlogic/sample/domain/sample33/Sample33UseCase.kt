package com.yugyd.buildlogic.sample.domain.sample33

import com.yugyd.buildlogic.sample.data.sample33.Sample33Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

class Sample33UseCase(
    private val sample33Repository: Sample33Repository,
) {

    operator fun invoke(): Flow<String> {
        return sample33Repository
            .getData()
            .flowOn(Dispatchers.IO)
    }
}

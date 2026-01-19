package com.yugyd.buildlogic.sample.domain.sample26

import com.yugyd.buildlogic.sample.data.sample26.Sample26Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

class Sample26UseCase(
    private val sample26Repository: Sample26Repository,
) {

    operator fun invoke(): Flow<String> {
        return sample26Repository
            .getData()
            .flowOn(Dispatchers.IO)
    }
}

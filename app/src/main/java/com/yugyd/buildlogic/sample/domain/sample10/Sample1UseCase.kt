package com.yugyd.buildlogic.sample.domain.sample10

import com.yugyd.buildlogic.sample.data.sample10.Sample10Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

class Sample10UseCase(
    private val sample10Repository: Sample10Repository,
) {

    operator fun invoke(): Flow<String> {
        return sample10Repository
            .getData()
            .flowOn(Dispatchers.IO)
    }
}

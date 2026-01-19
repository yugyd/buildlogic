package com.yugyd.buildlogic.sample.domain.sample55

import com.yugyd.buildlogic.sample.data.sample55.Sample55Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

class Sample55UseCase(
    private val sample55Repository: Sample55Repository,
) {

    operator fun invoke(): Flow<String> {
        return sample55Repository
            .getData()
            .flowOn(Dispatchers.IO)
    }
}

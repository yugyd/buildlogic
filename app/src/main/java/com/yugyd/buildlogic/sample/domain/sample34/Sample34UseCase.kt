package com.yugyd.buildlogic.sample.domain.sample34

import com.yugyd.buildlogic.sample.data.sample34.Sample34Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

class Sample34UseCase(
    private val sample34Repository: Sample34Repository,
) {

    operator fun invoke(): Flow<String> {
        return sample34Repository
            .getData()
            .flowOn(Dispatchers.IO)
    }
}

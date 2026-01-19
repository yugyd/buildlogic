package com.yugyd.buildlogic.sample.domain.sample7

import com.yugyd.buildlogic.sample.data.sample7.Sample7Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

class Sample7UseCase(
    private val sample7Repository: Sample7Repository,
) {

    operator fun invoke(): Flow<String> {
        return sample7Repository
            .getData()
            .flowOn(Dispatchers.IO)
    }
}

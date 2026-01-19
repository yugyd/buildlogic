package com.yugyd.buildlogic.sample.domain.sample20

import com.yugyd.buildlogic.sample.data.sample20.Sample20Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

class Sample20UseCase(
    private val sample20Repository: Sample20Repository,
) {

    operator fun invoke(): Flow<String> {
        return sample20Repository
            .getData()
            .flowOn(Dispatchers.IO)
    }
}

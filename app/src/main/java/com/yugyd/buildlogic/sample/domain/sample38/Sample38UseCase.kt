package com.yugyd.buildlogic.sample.domain.sample38

import com.yugyd.buildlogic.sample.data.sample38.Sample38Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

class Sample38UseCase(
    private val sample38Repository: Sample38Repository,
) {

    operator fun invoke(): Flow<String> {
        return sample38Repository
            .getData()
            .flowOn(Dispatchers.IO)
    }
}

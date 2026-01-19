package com.yugyd.buildlogic.sample.domain.sample39

import com.yugyd.buildlogic.sample.data.sample39.Sample39Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

class Sample39UseCase(
    private val sample39Repository: Sample39Repository,
) {

    operator fun invoke(): Flow<String> {
        return sample39Repository
            .getData()
            .flowOn(Dispatchers.IO)
    }
}

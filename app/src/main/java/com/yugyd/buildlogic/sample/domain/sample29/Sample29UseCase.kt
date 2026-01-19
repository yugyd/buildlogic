package com.yugyd.buildlogic.sample.domain.sample29

import com.yugyd.buildlogic.sample.data.sample29.Sample29Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

class Sample29UseCase(
    private val sample29Repository: Sample29Repository,
) {

    operator fun invoke(): Flow<String> {
        return sample29Repository
            .getData()
            .flowOn(Dispatchers.IO)
    }
}

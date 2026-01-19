package com.yugyd.buildlogic.sample.domain.sample44

import com.yugyd.buildlogic.sample.data.sample44.Sample44Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

class Sample44UseCase(
    private val sample44Repository: Sample44Repository,
) {

    operator fun invoke(): Flow<String> {
        return sample44Repository
            .getData()
            .flowOn(Dispatchers.IO)
    }
}

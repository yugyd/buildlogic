package com.yugyd.buildlogic.sample.domain.sample9

import com.yugyd.buildlogic.sample.data.sample9.Sample9Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

class Sample9UseCase(
    private val sample9Repository: Sample9Repository,
) {

    operator fun invoke(): Flow<String> {
        return sample9Repository
            .getData()
            .flowOn(Dispatchers.IO)
    }
}

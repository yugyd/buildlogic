package com.yugyd.buildlogic.sample.domain.sample24

import com.yugyd.buildlogic.sample.data.sample24.Sample24Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

class Sample24UseCase(
    private val sample24Repository: Sample24Repository,
) {

    operator fun invoke(): Flow<String> {
        return sample24Repository
            .getData()
            .flowOn(Dispatchers.IO)
    }
}

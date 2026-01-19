package com.yugyd.buildlogic.sample.domain.sample28

import com.yugyd.buildlogic.sample.data.sample28.Sample28Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

class Sample28UseCase(
    private val sample28Repository: Sample28Repository,
) {

    operator fun invoke(): Flow<String> {
        return sample28Repository
            .getData()
            .flowOn(Dispatchers.IO)
    }
}

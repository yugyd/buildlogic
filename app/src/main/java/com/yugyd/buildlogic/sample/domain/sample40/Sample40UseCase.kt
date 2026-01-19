package com.yugyd.buildlogic.sample.domain.sample40

import com.yugyd.buildlogic.sample.data.sample40.Sample40Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

class Sample40UseCase(
    private val sample40Repository: Sample40Repository,
) {

    operator fun invoke(): Flow<String> {
        return sample40Repository
            .getData()
            .flowOn(Dispatchers.IO)
    }
}

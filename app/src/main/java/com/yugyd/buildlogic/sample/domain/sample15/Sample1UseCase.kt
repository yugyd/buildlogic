package com.yugyd.buildlogic.sample.domain.sample15

import com.yugyd.buildlogic.sample.data.sample15.Sample15Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

class Sample15UseCase(
    private val sample15Repository: Sample15Repository,
) {

    operator fun invoke(): Flow<String> {
        return sample15Repository
            .getData()
            .flowOn(Dispatchers.IO)
    }
}

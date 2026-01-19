package com.yugyd.buildlogic.sample.domain.sample49

import com.yugyd.buildlogic.sample.data.sample49.Sample49Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

class Sample49UseCase(
    private val sample49Repository: Sample49Repository,
) {

    operator fun invoke(): Flow<String> {
        return sample49Repository
            .getData()
            .flowOn(Dispatchers.IO)
    }
}

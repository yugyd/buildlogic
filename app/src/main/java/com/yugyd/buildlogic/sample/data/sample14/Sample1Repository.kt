package com.yugyd.buildlogic.sample.data.sample14

import kotlinx.coroutines.flow.Flow

interface Sample14Repository {
    fun getData(): Flow<String>
}

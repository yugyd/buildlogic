package com.yugyd.buildlogic.sample.data.sample45

import kotlinx.coroutines.flow.Flow

interface Sample45Repository {
    fun getData(): Flow<String>
}

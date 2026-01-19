package com.yugyd.buildlogic.sample.data.sample60

import kotlinx.coroutines.flow.Flow

interface Sample60Repository {
    fun getData(): Flow<String>
}

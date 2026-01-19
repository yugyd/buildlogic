package com.yugyd.buildlogic.sample.data.sample3

import kotlinx.coroutines.flow.Flow

interface Sample3Repository {
    fun getData(): Flow<String>
}

package com.yugyd.buildlogic.sample.data.sample1

import kotlinx.coroutines.flow.Flow

interface Sample1Repository {
    fun getData(): Flow<String>
}

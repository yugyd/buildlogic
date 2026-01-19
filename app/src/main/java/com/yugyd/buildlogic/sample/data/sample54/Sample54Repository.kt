package com.yugyd.buildlogic.sample.data.sample54

import kotlinx.coroutines.flow.Flow

interface Sample54Repository {
    fun getData(): Flow<String>
}

package com.yugyd.buildlogic.sample.data.sample41

import kotlinx.coroutines.flow.Flow

interface Sample41Repository {
    fun getData(): Flow<String>
}

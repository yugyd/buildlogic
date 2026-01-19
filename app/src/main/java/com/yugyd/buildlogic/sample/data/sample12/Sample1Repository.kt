package com.yugyd.buildlogic.sample.data.sample12

import kotlinx.coroutines.flow.Flow

interface Sample12Repository {
    fun getData(): Flow<String>
}

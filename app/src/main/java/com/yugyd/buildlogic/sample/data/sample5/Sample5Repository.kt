package com.yugyd.buildlogic.sample.data.sample5

import kotlinx.coroutines.flow.Flow

interface Sample5Repository {
    fun getData(): Flow<String>
}

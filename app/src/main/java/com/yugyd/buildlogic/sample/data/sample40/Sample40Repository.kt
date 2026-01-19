package com.yugyd.buildlogic.sample.data.sample40

import kotlinx.coroutines.flow.Flow

interface Sample40Repository {
    fun getData(): Flow<String>
}

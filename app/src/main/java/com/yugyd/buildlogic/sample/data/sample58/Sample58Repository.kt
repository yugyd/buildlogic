package com.yugyd.buildlogic.sample.data.sample58

import kotlinx.coroutines.flow.Flow

interface Sample58Repository {
    fun getData(): Flow<String>
}

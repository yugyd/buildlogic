package com.yugyd.buildlogic.sample.data.sample43

import kotlinx.coroutines.flow.Flow

interface Sample43Repository {
    fun getData(): Flow<String>
}

package com.yugyd.buildlogic.sample.data.sample8

import kotlinx.coroutines.flow.Flow

interface Sample8Repository {
    fun getData(): Flow<String>
}

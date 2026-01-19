package com.yugyd.buildlogic.sample.data.sample16

import kotlinx.coroutines.flow.Flow

interface Sample16Repository {
    fun getData(): Flow<String>
}

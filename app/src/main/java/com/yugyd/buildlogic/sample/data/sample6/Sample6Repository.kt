package com.yugyd.buildlogic.sample.data.sample6

import kotlinx.coroutines.flow.Flow

interface Sample6Repository {
    fun getData(): Flow<String>
}

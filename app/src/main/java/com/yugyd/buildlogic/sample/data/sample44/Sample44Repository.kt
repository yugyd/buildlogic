package com.yugyd.buildlogic.sample.data.sample44

import kotlinx.coroutines.flow.Flow

interface Sample44Repository {
    fun getData(): Flow<String>
}

package com.yugyd.buildlogic.sample.data.sample10

import kotlinx.coroutines.flow.Flow

interface Sample10Repository {
    fun getData(): Flow<String>
}

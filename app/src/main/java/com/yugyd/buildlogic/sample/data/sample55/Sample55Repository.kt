package com.yugyd.buildlogic.sample.data.sample55

import kotlinx.coroutines.flow.Flow

interface Sample55Repository {
    fun getData(): Flow<String>
}

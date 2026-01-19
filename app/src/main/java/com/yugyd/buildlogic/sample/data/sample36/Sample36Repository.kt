package com.yugyd.buildlogic.sample.data.sample36

import kotlinx.coroutines.flow.Flow

interface Sample36Repository {
    fun getData(): Flow<String>
}

package com.yugyd.buildlogic.sample.data.sample30

import kotlinx.coroutines.flow.Flow

interface Sample30Repository {
    fun getData(): Flow<String>
}

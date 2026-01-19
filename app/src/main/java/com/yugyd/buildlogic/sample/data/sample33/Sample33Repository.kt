package com.yugyd.buildlogic.sample.data.sample33

import kotlinx.coroutines.flow.Flow

interface Sample33Repository {
    fun getData(): Flow<String>
}

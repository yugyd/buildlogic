package com.yugyd.buildlogic.sample.data.sample11

import kotlinx.coroutines.flow.Flow

interface Sample11Repository {
    fun getData(): Flow<String>
}

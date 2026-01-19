package com.yugyd.buildlogic.sample.data.sample46

import kotlinx.coroutines.flow.Flow

interface Sample46Repository {
    fun getData(): Flow<String>
}

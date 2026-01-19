package com.yugyd.buildlogic.sample.data.sample26

import kotlinx.coroutines.flow.Flow

interface Sample26Repository {
    fun getData(): Flow<String>
}

package com.yugyd.buildlogic.sample.data.sample53

import kotlinx.coroutines.flow.Flow

interface Sample53Repository {
    fun getData(): Flow<String>
}

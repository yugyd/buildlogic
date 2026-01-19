package com.yugyd.buildlogic.sample.data.sample24

import kotlinx.coroutines.flow.Flow

interface Sample24Repository {
    fun getData(): Flow<String>
}

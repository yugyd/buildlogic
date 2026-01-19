package com.yugyd.buildlogic.sample.data.sample56

import kotlinx.coroutines.flow.Flow

interface Sample56Repository {
    fun getData(): Flow<String>
}

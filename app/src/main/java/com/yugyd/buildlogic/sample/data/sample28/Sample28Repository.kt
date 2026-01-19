package com.yugyd.buildlogic.sample.data.sample28

import kotlinx.coroutines.flow.Flow

interface Sample28Repository {
    fun getData(): Flow<String>
}

package com.yugyd.buildlogic.sample.data.sample17

import kotlinx.coroutines.flow.Flow

interface Sample17Repository {
    fun getData(): Flow<String>
}

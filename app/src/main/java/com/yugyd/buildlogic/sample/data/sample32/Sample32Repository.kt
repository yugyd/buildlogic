package com.yugyd.buildlogic.sample.data.sample32

import kotlinx.coroutines.flow.Flow

interface Sample32Repository {
    fun getData(): Flow<String>
}

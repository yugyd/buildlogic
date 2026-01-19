package com.yugyd.buildlogic.sample.data.sample34

import kotlinx.coroutines.flow.Flow

interface Sample34Repository {
    fun getData(): Flow<String>
}

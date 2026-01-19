package com.yugyd.buildlogic.sample.data.sample21

import kotlinx.coroutines.flow.Flow

interface Sample21Repository {
    fun getData(): Flow<String>
}

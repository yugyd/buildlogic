package com.yugyd.buildlogic.sample.data.sample18

import kotlinx.coroutines.flow.Flow

interface Sample18Repository {
    fun getData(): Flow<String>
}

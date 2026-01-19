package com.yugyd.buildlogic.sample.data.sample15

import kotlinx.coroutines.flow.Flow

interface Sample15Repository {
    fun getData(): Flow<String>
}

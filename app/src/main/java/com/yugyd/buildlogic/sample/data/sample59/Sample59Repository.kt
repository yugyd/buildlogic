package com.yugyd.buildlogic.sample.data.sample59

import kotlinx.coroutines.flow.Flow

interface Sample59Repository {
    fun getData(): Flow<String>
}

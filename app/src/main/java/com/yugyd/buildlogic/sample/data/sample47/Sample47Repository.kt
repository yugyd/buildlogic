package com.yugyd.buildlogic.sample.data.sample47

import kotlinx.coroutines.flow.Flow

interface Sample47Repository {
    fun getData(): Flow<String>
}

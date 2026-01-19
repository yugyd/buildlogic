package com.yugyd.buildlogic.sample.data.sample25

import kotlinx.coroutines.flow.Flow

interface Sample25Repository {
    fun getData(): Flow<String>
}

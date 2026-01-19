package com.yugyd.buildlogic.sample.data.sample7

import kotlinx.coroutines.flow.Flow

interface Sample7Repository {
    fun getData(): Flow<String>
}

package com.yugyd.buildlogic.sample.data.sample22

import kotlinx.coroutines.flow.Flow

interface Sample22Repository {
    fun getData(): Flow<String>
}

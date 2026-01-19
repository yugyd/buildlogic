package com.yugyd.buildlogic.sample.data.sample29

import kotlinx.coroutines.flow.Flow

interface Sample29Repository {
    fun getData(): Flow<String>
}

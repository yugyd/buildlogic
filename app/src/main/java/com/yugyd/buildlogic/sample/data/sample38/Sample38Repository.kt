package com.yugyd.buildlogic.sample.data.sample38

import kotlinx.coroutines.flow.Flow

interface Sample38Repository {
    fun getData(): Flow<String>
}

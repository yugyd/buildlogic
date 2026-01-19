package com.yugyd.buildlogic.sample.data.sample20

import kotlinx.coroutines.flow.Flow

interface Sample20Repository {
    fun getData(): Flow<String>
}

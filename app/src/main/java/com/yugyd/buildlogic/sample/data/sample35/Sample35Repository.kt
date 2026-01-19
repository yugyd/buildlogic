package com.yugyd.buildlogic.sample.data.sample35

import kotlinx.coroutines.flow.Flow

interface Sample35Repository {
    fun getData(): Flow<String>
}

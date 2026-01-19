package com.yugyd.buildlogic.sample.data.sample42

import kotlinx.coroutines.flow.Flow

interface Sample42Repository {
    fun getData(): Flow<String>
}

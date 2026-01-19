package com.yugyd.buildlogic.sample.data.sample52

import kotlinx.coroutines.flow.Flow

interface Sample52Repository {
    fun getData(): Flow<String>
}

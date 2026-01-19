package com.yugyd.buildlogic.sample.data.sample31

import kotlinx.coroutines.flow.Flow

interface Sample31Repository {
    fun getData(): Flow<String>
}

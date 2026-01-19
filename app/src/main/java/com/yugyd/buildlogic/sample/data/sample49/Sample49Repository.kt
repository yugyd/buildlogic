package com.yugyd.buildlogic.sample.data.sample49

import kotlinx.coroutines.flow.Flow

interface Sample49Repository {
    fun getData(): Flow<String>
}

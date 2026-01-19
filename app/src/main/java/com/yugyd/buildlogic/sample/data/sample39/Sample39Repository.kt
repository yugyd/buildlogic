package com.yugyd.buildlogic.sample.data.sample39

import kotlinx.coroutines.flow.Flow

interface Sample39Repository {
    fun getData(): Flow<String>
}

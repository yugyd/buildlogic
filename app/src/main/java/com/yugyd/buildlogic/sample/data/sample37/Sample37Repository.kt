package com.yugyd.buildlogic.sample.data.sample37

import kotlinx.coroutines.flow.Flow

interface Sample37Repository {
    fun getData(): Flow<String>
}

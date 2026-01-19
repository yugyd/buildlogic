package com.yugyd.buildlogic.sample.data.sample23

import kotlinx.coroutines.flow.Flow

interface Sample23Repository {
    fun getData(): Flow<String>
}

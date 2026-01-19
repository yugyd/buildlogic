package com.yugyd.buildlogic.sample.data.sample51

import kotlinx.coroutines.flow.Flow

interface Sample51Repository {
    fun getData(): Flow<String>
}

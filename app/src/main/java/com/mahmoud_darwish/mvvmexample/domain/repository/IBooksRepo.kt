package com.mahmoud_darwish.mvvmexample.domain.repository

import com.mahmoud_darwish.mvvmexample.domain.model.Volume
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

interface IBooksRepo {
    fun setQueryString(query: String)
    val searchResult: Flow<List<Volume>>
    val query: StateFlow<String>
}
package com.mahmoud_darwish.mvvmexample.data.repository

import com.mahmoud_darwish.mvvmexample.data.GoogleBooksApi
import com.mahmoud_darwish.mvvmexample.data.model.VolumeSearchResponseDto
import com.mahmoud_darwish.mvvmexample.data.model.mapper.toVolume
import com.mahmoud_darwish.mvvmexample.domain.model.Volume
import com.mahmoud_darwish.mvvmexample.domain.repository.IBooksRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.transform
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BooksRepoImpl @Inject constructor(
    private val googleBooksApi: GoogleBooksApi
) : IBooksRepo {

    override var query = MutableStateFlow("java")

    override fun setQueryString(query: String) {
        this.query.value = query
    }

    override val searchResult: Flow<List<Volume>> = query.transform { query ->
        val searchResult: List<VolumeSearchResponseDto.VolumeDto> =
            googleBooksApi.search(query).items
        emit(searchResult.map { it.toVolume() })
    }
}
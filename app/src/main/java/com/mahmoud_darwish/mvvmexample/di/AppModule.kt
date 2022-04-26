package com.mahmoud_darwish.mvvmexample.di

import com.mahmoud_darwish.mvvmexample.data.GoogleBooksApi
import com.mahmoud_darwish.mvvmexample.data.getBooksServiceInstance
import com.mahmoud_darwish.mvvmexample.data.repository.BooksRepoImpl
import com.mahmoud_darwish.mvvmexample.domain.repository.IBooksRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideBooksApi(): GoogleBooksApi = getBooksServiceInstance()

    @Singleton
    @Provides
    fun provideBooksRepo(booksRepoImpl: BooksRepoImpl): IBooksRepo = booksRepoImpl
}
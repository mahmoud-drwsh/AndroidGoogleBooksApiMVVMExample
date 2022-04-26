package com.mahmoud_darwish.mvvmexample.data

import com.mahmoud_darwish.mvvmexample.data.model.VolumeSearchResponseDto
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

const val BASE = "https://www.googleapis.com/books/v1/"

interface GoogleBooksApi {
    @GET("volumes")
    suspend fun search(
        @Query("q") q: String,
        @Query("maxResults") maxResults: Int = 40,
        @Query("printType") printType: String = "books",
        @Query("filter") filter: String = "paid-ebooks"
    ): VolumeSearchResponseDto

    @GET("volumes/{id}")
    suspend fun volume(@Path("id") id: String
    ): VolumeSearchResponseDto.VolumeDto
}


fun getBooksServiceInstance(): GoogleBooksApi = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE)
    .build()
    .create(GoogleBooksApi::class.java)

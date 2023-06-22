package org.muhammadsadri.scholarship4us.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.muhammadsadri.scholarship4us.model.Post
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://scholarship4us.com/wp-json/wp/v2/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface PostApiService {
    @GET("posts")
    suspend fun getPosts(): List<Post>
}

object PostApi {
    val service: PostApiService by lazy {
        retrofit.create(PostApiService::class.java)
    }
}

enum class ApiStatus { LOADING, SUCCESS, FAILED }


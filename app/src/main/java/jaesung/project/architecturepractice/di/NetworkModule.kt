package jaesung.project.architecturepractice.di

import jaesung.project.architecturepractice.data.network.ApiService
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single<OkHttpClient> {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC))
            .addInterceptor(Interceptor { chain ->
                chain.proceed(
                    chain.request().newBuilder().addHeader("Authorization", "abcd").build()
                )
            }).build()
    }

    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl("http://3.37.224.92:8080/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
    }

    single<ApiService> {
        get<Retrofit>().create(ApiService::class.java)
    }

}
package com.example.unsplushdiplom.di

import com.example.user.models.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkProvider {

//    @Provides
//    @Singleton
//    fun providesOkhttpClient(): OkHttpClient.Builder {
//        return OkHttpClient.Builder()
//            .connectTimeout(Constants.timeOut, TimeUnit.SECONDS)
//            .addNetworkInterceptor(
//                HttpLoggingInterceptor()
//                    .setLevel(HttpLoggingInterceptor.Level.BODY)
//            )
//    }

    @Provides
    fun provideOkhttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(Constants.timeOut, TimeUnit.SECONDS)
            .addNetworkInterceptor(
                HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BODY)
            )
            .followRedirects(true)
            .build()
    }

//    @Provides
//    @Singleton
//    fun providesRetrofitClient(
//        @Named("BASE_URL") baseurl: String,
//        okHttpClient: OkHttpClient
//    ): Retrofit = Retrofit.Builder()
//        .client(okHttpClient)
//        .baseUrl(baseurl)
//        .addConverterFactory(GsonConverterFactory.create())
//        .build()

    @Singleton
    @Provides
    fun provideRetrofit(client: OkHttpClient): Retrofit.Builder {
        return Retrofit.Builder()
            .client(client)
            .baseUrl(Constants.oauthBase)
            .addConverterFactory(GsonConverterFactory.create())
           // .build()
    }

    @Provides
    @Singleton
    fun providesNetworkService(retrofit: Retrofit) = ServiceProvider(retrofit = retrofit)
}

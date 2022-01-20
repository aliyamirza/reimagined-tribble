package com.smartheard.aaratechnologypvtltd.Network

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class RetroInstance {

        @Provides
        @Singleton
        fun getRetrofitInstance() : RetrofitServices{

            val logging = HttpLoggingInterceptor()
            logging.level = (HttpLoggingInterceptor.Level.BODY)
            val client = OkHttpClient.Builder()
            client.addInterceptor(logging)

            return Retrofit.Builder()
                    .baseUrl(RetrofitServices.BASE_URL)
                    .client(client.build())
                    .addConverterFactory(GsonConverterFactory.create())

                    .build()
                .create(RetrofitServices::class.java)

        }

}
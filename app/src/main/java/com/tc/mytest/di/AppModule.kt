package com.tc.mytest.di

import com.tc.mytest.data.remote.ApiDetails
import com.tc.mytest.data.remote.ApiRequest
import com.tc.mytest.data.repository.Repository
import com.tc.mytest.data.repository.RepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    //Creating the OKHttpClient for interception
    @Provides
    fun provideOkHttp(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            )
            .build()
    }

    //Using Retrofit to get the API call
    @Provides
    fun provideApi(
        provideOkHttpClient: OkHttpClient
    ): ApiRequest {
        return Retrofit.Builder()
            .baseUrl(ApiDetails.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(provideOkHttpClient)
            .build()
            .create(ApiRequest::class.java)
    }

    //Merging the repository class together
    @Provides
    fun provideRepository(
        apiRequest: ApiRequest
    ): Repository {
        return RepositoryImpl(apiRequest)
    }

}

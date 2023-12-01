package com.example.countrypedia.data.di

import com.example.countrypedia.data.remote.CountryAPI
import com.example.countrypedia.data.repository.CountryRepositoryImpl
import com.example.countrypedia.domain.repository.CountryRepository
import com.example.countrypedia.domain.use_case.GetCountriesUseCase
import com.example.countrypedia.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideCountryAPI(): CountryAPI {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(CountryAPI::class.java)
    }


    @Provides
    @Singleton
    fun provideCountryRepository(api: CountryAPI): CountryRepository {
        return CountryRepositoryImpl(api)
    }


}
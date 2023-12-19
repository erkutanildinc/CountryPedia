package com.example.countrypedia.data.remote

import com.example.countrypedia.data.remote.dto.CountryDTO
import com.example.countrypedia.data.remote.dto.CountryDTOElement
import com.example.countrypedia.domain.model.Country
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CountryAPI {

    @GET("all")
    suspend fun getAllCountries() : ArrayList<CountryDTOElement>

    @GET("name/{countryName}")
    suspend fun getCountryByName(@Path("countryName") countryName : String) : ArrayList<CountryDTOElement>

}
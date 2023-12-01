package com.example.countrypedia.data.remote

import com.example.countrypedia.data.remote.dto.CountryDTO
import com.example.countrypedia.data.remote.dto.CountryDTOElement
import com.example.countrypedia.domain.model.Country
import retrofit2.http.GET

interface CountryAPI {

    @GET("all")
    suspend fun getAllCountries() : ArrayList<CountryDTOElement>

}
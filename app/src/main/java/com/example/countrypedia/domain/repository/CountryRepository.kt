package com.example.countrypedia.domain.repository

import com.example.countrypedia.data.remote.dto.CountryDTO
import com.example.countrypedia.data.remote.dto.CountryDTOElement

interface CountryRepository {

    suspend fun getCountries() : ArrayList<CountryDTOElement>

}
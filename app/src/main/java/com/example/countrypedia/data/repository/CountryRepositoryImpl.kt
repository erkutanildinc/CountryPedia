package com.example.countrypedia.data.repository

import com.example.countrypedia.data.remote.CountryAPI
import com.example.countrypedia.data.remote.dto.CountryDTO
import com.example.countrypedia.data.remote.dto.CountryDTOElement
import com.example.countrypedia.domain.repository.CountryRepository
import javax.inject.Inject

class CountryRepositoryImpl @Inject constructor(private val api : CountryAPI) : CountryRepository {

    override suspend fun getCountries(): ArrayList<CountryDTOElement> {
        return api.getAllCountries()
    }
}
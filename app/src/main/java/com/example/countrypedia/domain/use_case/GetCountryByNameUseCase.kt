package com.example.countrypedia.domain.use_case

import com.example.countrypedia.data.remote.dto.CountryDTOElement
import com.example.countrypedia.domain.repository.CountryRepository
import com.example.countrypedia.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class GetCountryByNameUseCase @Inject constructor(private val repository: CountryRepository) {

    fun executeGetCountryByName(countryName : String) : Flow<Resource<CountryDTOElement>> = flow {
        try {
            emit(Resource.Loading())
            val country = repository.getCountriesByName(countryName) as List<CountryDTOElement>
            emit(Resource.Success(country.first()))
        }
        catch (e : IOException){
            emit(Resource.Error("No Internet Connection"))
        }
    }
}
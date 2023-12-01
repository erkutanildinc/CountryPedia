package com.example.countrypedia.domain.use_case

import com.example.countrypedia.data.remote.dto.CountryDTOElement
import com.example.countrypedia.data.remote.dto.toCountryList
import com.example.countrypedia.data.repository.CountryRepositoryImpl
import com.example.countrypedia.domain.model.Country
import com.example.countrypedia.domain.repository.CountryRepository
import com.example.countrypedia.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class GetCountriesUseCase @Inject constructor(private val repository: CountryRepository){

    fun executeGetCountries() : Flow<Resource<List<CountryDTOElement>>> = flow {
        try {
            emit(Resource.Loading())
            val countryList = repository.getCountries() as List<CountryDTOElement>
            emit(Resource.Success(countryList))
        }
        catch (e : IOException){
            emit(Resource.Error("No Internet Connection"))
        }
    }
}
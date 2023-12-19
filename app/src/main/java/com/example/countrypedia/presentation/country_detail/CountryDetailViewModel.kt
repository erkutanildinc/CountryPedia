package com.example.countrypedia.presentation.country_detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.countrypedia.domain.use_case.GetCountryByNameUseCase
import com.example.countrypedia.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CountryDetailViewModel @Inject constructor(private val getCountryByNameUseCase: GetCountryByNameUseCase): ViewModel() {

    private val _state = MutableStateFlow(CountryDetailState())
    val state : StateFlow<CountryDetailState> = _state

    fun getCountryByName(countryName : String){
        getCountryByNameUseCase.executeGetCountryByName(countryName = countryName).onEach {
            when(it){
                is Resource.Success ->{
                    _state.value = CountryDetailState(country = it.data)
                }
                is Resource.Error -> {
                    _state.value = CountryDetailState(error = "Error!")
                }
                is Resource.Loading -> {
                    _state.value = CountryDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}
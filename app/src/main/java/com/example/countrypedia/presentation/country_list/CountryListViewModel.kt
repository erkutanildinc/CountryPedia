package com.example.countrypedia.presentation.country_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.countrypedia.domain.use_case.GetCountriesUseCase
import com.example.countrypedia.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CountryListViewModel @Inject constructor(private val getCountriesUseCase: GetCountriesUseCase) : ViewModel() {

    private val _state = MutableStateFlow(CountryListState())
    val state : StateFlow<CountryListState> = _state

    fun getCountries(){
        getCountriesUseCase.executeGetCountries().onEach {
            when(it){
                is Resource.Success ->{
                    _state.value = CountryListState(countries = it.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = CountryListState(error = "Error!")
                }
                is Resource.Loading -> {
                    _state.value = CountryListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

}
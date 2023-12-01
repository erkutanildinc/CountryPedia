package com.example.countrypedia.presentation.country_list

import com.example.countrypedia.data.remote.dto.CountryDTOElement
import com.example.countrypedia.domain.model.Country

data class CountryListState(
    val isLoading: Boolean = false,
    val countries: List<CountryDTOElement> = emptyList(),
    val error: String = ""
)
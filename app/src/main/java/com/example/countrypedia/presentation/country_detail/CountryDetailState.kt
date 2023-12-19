package com.example.countrypedia.presentation.country_detail

import com.example.countrypedia.data.remote.dto.CountryDTOElement

data class CountryDetailState(
    val isLoading: Boolean = false,
    val country: CountryDTOElement? = null,
    val error: String = ""
)
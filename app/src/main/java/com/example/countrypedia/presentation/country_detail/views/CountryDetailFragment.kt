package com.example.countrypedia.presentation.country_detail.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.manager.Lifecycle
import com.example.countrypedia.R
import com.example.countrypedia.data.remote.dto.CountryDTOElement
import com.example.countrypedia.domain.model.Country
import com.example.countrypedia.presentation.adapter.CountryAdapter
import com.example.countrypedia.presentation.country_detail.CountryDetailViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

@AndroidEntryPoint
class CountryDetailFragment : Fragment() {

    private val viewModel : CountryDetailViewModel by viewModels()
    private lateinit var countryName : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            countryName = com.example.countrypedia.presentation.country_detail.views.CountryDetailFragmentArgs.fromBundle(it).countryName
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_country_detail, container, false)
        // Inflate the layout for this fragment
        viewModel.getCountryByName(countryName)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val job = CoroutineScope(Dispatchers.IO).launch {
            viewModel.state.collect{
                it.country?.let {
                    withContext(Dispatchers.Main){
                       println(it.name.common)
                    }
                }
            }
        }
    }
}


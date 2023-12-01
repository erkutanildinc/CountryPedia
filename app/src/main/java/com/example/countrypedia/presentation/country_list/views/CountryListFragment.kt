package com.example.countrypedia.presentation.country_list.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.countrypedia.R
import com.example.countrypedia.presentation.adapter.CountryAdapter
import com.example.countrypedia.presentation.country_list.CountryListState
import com.example.countrypedia.presentation.country_list.CountryListViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@AndroidEntryPoint
class CountryListFragment() : Fragment() {

    private val viewModel : CountryListViewModel by viewModels()
    private lateinit var countryRecyclerView : RecyclerView
    lateinit var countryAdapter : CountryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_country_list, container, false)
        countryRecyclerView = view.findViewById(R.id.countryListRecyclerView)
        viewModel.getCountries()
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        countryRecyclerView.layoutManager = GridLayoutManager(context,2)

        CoroutineScope(Dispatchers.IO).launch {


            viewModel.state.collect{
                it.countries?.let {
                    withContext(Dispatchers.Main){
                        countryAdapter = CountryAdapter(it)
                        countryRecyclerView.adapter = countryAdapter
                    }
                }
            }

        }
    }

}
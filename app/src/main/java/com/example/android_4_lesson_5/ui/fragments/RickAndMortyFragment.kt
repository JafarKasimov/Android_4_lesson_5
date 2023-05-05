package com.example.android_4_lesson_5.ui.fragments

import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.android4lesson5.R
import com.example.android4lesson5.databinding.FragmentRickAndMortyBinding
import com.example.android_4_lesson_5.base.BaseFragment
import com.example.android_4_lesson_5.ui.adapter.RickAndMortyAdapter
import com.example.android_4_lesson_5.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RickAndMortyFragment :
    BaseFragment<FragmentRickAndMortyBinding, RickAndMortyViewModel>(R.layout.fragment_rick_and_morty) {

    override val binding by viewBinding(FragmentRickAndMortyBinding::bind)
    override val viewModel: RickAndMortyViewModel by viewModels()
    private var rickAndMortyAdapter = RickAndMortyAdapter()

    override fun initialize() {
        binding.recView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = rickAndMortyAdapter
        }
        subscribeToGetData()
    }

    private fun subscribeToGetData() {
        viewModel.noteLiveData.observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Error -> {}
                is Resource.Loading -> {}
                is Resource.Success -> {
                        rickAndMortyAdapter.submitList(it.data)
                }
            }
        }
    }
}
package com.insureka.myapplication.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.insureka.myapplication.MainViewModel
import com.insureka.myapplication.Rating
import com.insureka.myapplication.RatingAdapter
import com.insureka.myapplication.databinding.FragmentIdvTestBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class IDVTestFragment : Fragment() {

    private lateinit var binding: FragmentIdvTestBinding
    private lateinit var adapter: RatingAdapter
    private lateinit var layoutManager: LinearLayoutManager
    private lateinit var recyclerView: RecyclerView
    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentIdvTestBinding.inflate(inflater, container, false)
        recyclerView = binding.recyclerview
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()

        viewModel.viewState.observe(viewLifecycleOwner, {
            it.idvDataList.let { idvList ->
                if (idvList.isNotEmpty()) {
                    adapter.setData(idvList)
                }
            }
        })
    }

    private fun initRecyclerView() {
        adapter = RatingAdapter(viewModel)
        layoutManager = LinearLayoutManager(requireContext())
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
    }
}

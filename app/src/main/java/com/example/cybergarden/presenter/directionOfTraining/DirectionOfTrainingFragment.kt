package com.example.cybergarden.presenter.directionOfTraining

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cybergarden.R
import com.example.cybergarden.data.DoubleItem
import com.example.cybergarden.data.FilterReq
import com.example.cybergarden.databinding.DirectionOfTrainingLayoutBinding
import com.example.cybergarden.presenter.utils.Constants

class DirectionOfTrainingFragment : Fragment() {

    private val viewModel: DirectionOfTrainingViewModel by viewModels()
    private lateinit var binding: DirectionOfTrainingLayoutBinding
    private val data = mutableListOf<DoubleItem>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DirectionOfTrainingLayoutBinding.inflate(inflater, container, false)
        binding.toolbar.apply {
            toolbarTitle.setText(R.string.choose_direction)
            back.visibility = View.VISIBLE
            back.setOnClickListener {
                findNavController().popBackStack()
            }
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = DirectionAdapter(data)
        binding.actionButton.setOnClickListener {
            findNavController().navigate(R.id.direction_of_training_to_dialog_fragment)
        }

        viewModel.getDirection()

        viewModel.newsSizeMLD.observe(this, {
            if (it != null) {
                data.clear()
                data.addAll(it)
                binding.recyclerView.adapter?.notifyDataSetChanged()
            } else {
                Toast.makeText(requireContext(), R.string.error_list, Toast.LENGTH_SHORT).show()
            }
        })

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        if (Constants.FILTER) {
            Constants.FILTER = false
            var list = mutableListOf<String>()
            if (Constants.math) {
                list.add("matem")
            }
            if (Constants.inform && list.size < 1) {
                list.add("infor")
            }
            if (Constants.other && list.size < 1) {
                list.add("other")
            }
            val filter = FilterReq(list, Constants.summ)
            viewModel.postFilter(filter)
        }
    }

}
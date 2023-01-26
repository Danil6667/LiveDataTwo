package com.example.livedatatwo.ui.fragment.first

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.livedatatwo.R
import com.example.livedatatwo.databinding.FragmentFirstBinding
import com.example.livedatatwo.ui.adapter.NotesAdapter

class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding
    private val viewModel by activityViewModels<FirstViewModel>()
    private var notesAdapter = NotesAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onClick()
        navigations()
        setupClick()
    }

    private fun onClick() {
        binding.rvList.adapter = notesAdapter
        }

    private fun navigations() {
        binding.button.setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_sendFragment)
        }
    }

    private fun setupClick() {
        viewModel.imageLiveData.observe(viewLifecycleOwner) {
            notesAdapter.submitList(it)
        }
    }
}
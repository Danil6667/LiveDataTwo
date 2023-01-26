package com.example.livedatatwo.ui.fragment.send

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.livedatatwo.databinding.FragmentSendBinding
import com.example.livedatatwo.ui.fragment.first.FirstViewModel

class SendFragment : Fragment() {

    private lateinit var binding: FragmentSendBinding
    private val viewModel by activityViewModels<FirstViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentSendBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onClick()
    }

    private fun onClick() {
        binding.btnSend.setOnClickListener{
            val number = binding.number.text.toString().trim()
            val title = binding.title.text.toString().trim()
            val description = binding.description.text.toString().trim()

            viewModel.addNote(number = number, title = title, description = description)
            findNavController().navigateUp()
        }
    }
}
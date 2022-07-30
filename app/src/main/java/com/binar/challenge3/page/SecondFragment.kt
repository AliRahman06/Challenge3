package com.binar.challenge3.page

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.binar.challenge3.Person
import com.binar.challenge3.ValidationForm.isValid
import com.binar.challenge3.databinding.FragmentSecondBinding


class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnGoToScreen3.setOnClickListener {
            if (isFormValid()){
                val name = binding.etNama.text.toString()
                val person = Person(name)
                val action = SecondFragmentDirections.actionSecondFragmentToThirdFragment(person)
                it.findNavController().navigate(action)
            }
        }

    }

    private fun isFormValid():Boolean{
        val name = binding.etNama
        return name.isValid()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
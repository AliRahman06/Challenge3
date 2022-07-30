package com.binar.challenge3.page

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.updateLayoutParams
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.binar.challenge3.databinding.FragmentThirdBinding


class ThirdFragment : Fragment() {


    private var _binding: FragmentThirdBinding? = null
    private val binding get() = _binding!!

    private val args: ThirdFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentThirdBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvNama.text = "Nama: ${args.person.name}"
        if (args.person.age == null){
            hideResult()
        }else{
            showResult()
        }

        binding.btnGoToScreen4.setOnClickListener {
            val action = ThirdFragmentDirections
                .actionThirdFragmentToFourthFragment(args.person.name)
            it.findNavController().navigate(action)
        }

    }

    private fun showResult(){
        with(binding){
            tvAge.visibility = View.VISIBLE
            tvHeight.visibility = View.VISIBLE
            tvWeight.visibility = View.VISIBLE
            tvGender.visibility = View.VISIBLE
            btnGoToScreen4.visibility = View.GONE
            tvNama.updateLayoutParams<ConstraintLayout.LayoutParams> { verticalBias = 0.0f }

            tvAge.text = "Umur: ${args.person.age} tahun"
            tvHeight.text = "Tinggi: ${args.person.height}cm"
            tvWeight.text = "Berat: ${args.person.weight}kg"
            tvGender.text = "Jenis Kelamin: ${args.person.gender}"

        }

    }

    private fun hideResult(){
        with(binding){
            tvAge.visibility = View.GONE
            tvHeight.visibility = View.GONE
            tvWeight.visibility = View.GONE
            tvGender.visibility = View.GONE
            btnGoToScreen4.visibility = View.VISIBLE
            tvNama.updateLayoutParams<ConstraintLayout.LayoutParams> { verticalBias = 1.0f }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}
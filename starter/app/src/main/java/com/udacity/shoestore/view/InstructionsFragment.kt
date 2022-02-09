package com.udacity.shoestore.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentInstructionsBinding

class InstructionsFragment : Fragment() {

    private lateinit var binding: FragmentInstructionsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_instructions,container,false)

        binding.shoeListButton.setOnClickListener {
            if(binding.checkBox.isChecked){
                findNavController().navigate(R.id.action_instructionsFragment_to_shoeListFragment)
            }
            else{
                Toast.makeText(activity,"Please verify the box to proceed", Toast.LENGTH_LONG).show()
            }
        }

        return binding.root
    }

}
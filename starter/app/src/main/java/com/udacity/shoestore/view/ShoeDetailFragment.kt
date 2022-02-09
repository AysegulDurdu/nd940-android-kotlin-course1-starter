package com.udacity.shoestore.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.viewmodel.ShoeListViewModel

class ShoeDetailFragment : Fragment() {
    private var shoe  = Shoe()

    private val shoeListViewModel: ShoeListViewModel by activityViewModels()

    private lateinit var binding: FragmentShoeDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail,container,false)

        binding.modelShoe = shoe

        binding.btnSave.setOnClickListener {

            if (shoeDetails()) {
                shoeListViewModel.addShoe(shoe)
                findNavController().navigate(R.id.action_shoeDetailFragment_to_shoeListFragment)
            } else {
                Toast.makeText(activity, "Please correct the shoe details", Toast.LENGTH_LONG).show()
            }
        }

        binding.btnCancel.setOnClickListener {
            findNavController().navigate(R.id.action_shoeDetailFragment_to_shoeListFragment)
        }
        return binding.root
    }

    private fun shoeDetails(): Boolean {

        val name = shoe.name
        val size = shoe.size.toString()
        val company = shoe.company
        val description = shoe.description

        return !(name.isEmpty() || size.isEmpty() || company.isEmpty() || description.isEmpty())

    }

}
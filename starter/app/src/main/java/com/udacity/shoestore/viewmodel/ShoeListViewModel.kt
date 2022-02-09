package com.udacity.shoestore.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel: ViewModel() {

    private var _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList : LiveData<MutableList<Shoe>>
        get() = _shoeList

    private var _shoeAdd = MutableLiveData<Boolean>()
    val shoeAdd : LiveData<Boolean>
        get() = _shoeAdd

    init {
        _shoeList.value = mutableListOf(
            Shoe("Nike Air Max Bella", 38.0, "Nike", "Women's Training Shoe"),
            Shoe("Nike MC Trainer", 38.5, "Nike", "Men's Training Shoe"),
            Shoe("Nike Air Max Bella", 38.0, "Nike", "Women's Training Shoe"),
            Shoe("Nike Air Max Bella", 38.0, "Nike", "Women's Training Shoe"),
            Shoe("Nike MC Trainer", 38.5, "Nike", "Men's Training Shoe"),
            Shoe("Nike Air Max Bella", 38.0, "Nike", "Women's Training Shoe"))
    }

    fun addShoe(shoe: Shoe) {
        shoeList.value!!.add(shoe)
        _shoeAdd.value = false

    }



}
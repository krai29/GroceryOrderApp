package com.krai29.groceryorderapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.krai29.groceryorderapp.data.db.ShoppingItem
import com.krai29.groceryorderapp.data.repositories.ShoppingRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShoppingViewModel(private val shoppingRepository: ShoppingRepository) : ViewModel() {

    fun upsert(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        shoppingRepository.upsert(item)
    }

    fun delete(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        shoppingRepository.delete(item)
    }

    fun getAllShoppingItems() = shoppingRepository.getAllShoppingItems()
}
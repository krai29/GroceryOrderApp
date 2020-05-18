package com.krai29.groceryorderapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.krai29.groceryorderapp.R
import com.krai29.groceryorderapp.data.db.ShoppingDatabase
import com.krai29.groceryorderapp.data.repositories.ShoppingRepository
import com.krai29.groceryorderapp.ui.viewmodel.ShoppingViewModel
import com.krai29.groceryorderapp.ui.viewmodel.ShoppingViewModelFactory

class ShoppingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)

        val database = ShoppingDatabase(this)
        val repository = ShoppingRepository(database)
        val factory = ShoppingViewModelFactory(repository)

        val shoppingViewModel = ViewModelProvider(this,factory).get(ShoppingViewModel::class.java)
    }
}

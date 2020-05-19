package com.krai29.groceryorderapp.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.krai29.groceryorderapp.R
import com.krai29.groceryorderapp.data.db.ShoppingDatabase
import com.krai29.groceryorderapp.data.db.ShoppingItem
import com.krai29.groceryorderapp.data.repositories.ShoppingRepository
import com.krai29.groceryorderapp.ui.adapter.ShoppingItemAdapter
import com.krai29.groceryorderapp.ui.dialog.AddDialogListener
import com.krai29.groceryorderapp.ui.dialog.AddShoppingItemDialog
import com.krai29.groceryorderapp.ui.viewmodel.ShoppingViewModel
import com.krai29.groceryorderapp.ui.viewmodel.ShoppingViewModelFactory
import kotlinx.android.synthetic.main.activity_shopping.*

class ShoppingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)

        val database = ShoppingDatabase(this)
        val repository = ShoppingRepository(database)
        val factory = ShoppingViewModelFactory(repository)

        val shoppingViewModel = ViewModelProvider(this,factory).get(ShoppingViewModel::class.java)

        val adapter = ShoppingItemAdapter(listOf(),shoppingViewModel)
        rvShoppingRecyclerView.layoutManager = LinearLayoutManager(this)
        rvShoppingRecyclerView.adapter = adapter

        shoppingViewModel.getAllShoppingItems().observe(this, Observer {
            adapter.items = it
            adapter.notifyDataSetChanged()
        })

        fabAdd.setOnClickListener {
            AddShoppingItemDialog(this,object : AddDialogListener{
                override fun onAddButtonClicked(item: ShoppingItem) {
                    shoppingViewModel.upsert(item)
                }
            }).show()
        }
    }
}

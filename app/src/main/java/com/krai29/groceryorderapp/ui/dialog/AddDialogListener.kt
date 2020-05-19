package com.krai29.groceryorderapp.ui.dialog

import com.krai29.groceryorderapp.data.db.ShoppingItem

interface AddDialogListener {

    fun onAddButtonClicked(item : ShoppingItem)
}
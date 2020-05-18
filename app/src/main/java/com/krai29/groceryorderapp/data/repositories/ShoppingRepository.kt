package com.krai29.groceryorderapp.data.repositories

import com.krai29.groceryorderapp.data.db.ShoppingDatabase
import com.krai29.groceryorderapp.data.db.ShoppingItem

class ShoppingRepository(val db : ShoppingDatabase) {

    suspend fun upsert(item: ShoppingItem) = db.getShoppingDao().upsert(item)

    suspend fun delete(item: ShoppingItem) = db.getShoppingDao().delete(item)

    fun getAllShoppingItems() = db.getShoppingDao().getAllShoppingItems()
}
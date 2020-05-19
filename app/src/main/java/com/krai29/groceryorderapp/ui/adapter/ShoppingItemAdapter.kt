package com.krai29.groceryorderapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.krai29.groceryorderapp.R
import com.krai29.groceryorderapp.data.db.ShoppingItem
import com.krai29.groceryorderapp.ui.viewmodel.ShoppingViewModel
import kotlinx.android.synthetic.main.shopping_item.view.*

class ShoppingItemAdapter(
    var items : List<ShoppingItem>,
    val viewModel: ShoppingViewModel
) : RecyclerView.Adapter<ShoppingItemAdapter.ShoppingItemViewHolder>() {

    inner class ShoppingItemViewHolder(itemView : View):RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.shopping_item,parent,false)
        return ShoppingItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ShoppingItemViewHolder, position: Int) {
        val curShoppingItem = items[position]
        holder.itemView.tvName.text = curShoppingItem.name
        holder.itemView.tvAmount.text = curShoppingItem.amount.toString()

        holder.itemView.ivDelete.setOnClickListener {
            viewModel.delete(curShoppingItem)
        }

        holder.itemView.ivPlus.setOnClickListener {
            curShoppingItem.amount++
            viewModel.upsert(curShoppingItem)
        }

        holder.itemView.ivMinus.setOnClickListener {
            if(curShoppingItem.amount>0){
                curShoppingItem.amount--
                viewModel.upsert(curShoppingItem)
            }
        }
    }
}
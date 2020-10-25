package com.example.e_commerce.Adapters

import android.graphics.Rect
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Dimension
import androidx.recyclerview.widget.RecyclerView
import com.example.e_commerce.Data.Product
import com.example.e_commerce.R
import kotlinx.android.synthetic.main.item_list_product.view.*

class ProductsListAdapter(val products: List<Product>?, val listener:Listener): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    interface Listener {
        fun onClickProduct(product: Product)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val viewHolder = ProductHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_list_product, parent, false)
        )
        viewHolder.itemView.setOnClickListener {
            if (viewHolder.product != null)
                listener.onClickProduct(viewHolder.product!!)
        }
        return viewHolder
    }



    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ProductHolder)
            holder.product = products?.get(position)
    }

    override fun getItemCount(): Int {
        return products!!.size
    }

}
class ProductHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    var product:Product? = null
    set(value) {
        field = value
        itemView.productTitiletextView.text = value?.name
        itemView.amounttextView.text = value?.amount.toString()
        itemView.pricetextView.text = value?.price.toString()
    }
}
class CharacterItemDecoration(@Dimension private val padding: Int) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.left = padding
    }
}
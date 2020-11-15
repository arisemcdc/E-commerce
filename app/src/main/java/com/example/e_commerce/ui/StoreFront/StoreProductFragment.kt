package com.example.e_commerce.ui.StoreFront

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavArgs
import com.example.e_commerce.Data.Product
import com.example.e_commerce.Data.Repository
import com.example.e_commerce.EcommerceApp
import com.example.e_commerce.R
import kotlinx.android.synthetic.main.fragment_store_product.view.*


class StoreProductFragment(val product: Product) : Fragment() {
    lateinit var root: View
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        root = inflater.inflate(R.layout.fragment_store_product,  container, false)
        setProductsValues()
        return root
    }
    private fun setProductsValues() {
        root.nametextView.setText(product.name)
        root.pricetextViewValue.setText(product.price.toString())
        root.amounttextViewValue.setText(product.amount.toString())
    }
}
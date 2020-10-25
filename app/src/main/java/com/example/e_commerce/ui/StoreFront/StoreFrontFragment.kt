package com.example.e_commerce.ui.StoreFront

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.viewModels
import com.example.e_commerce.Data.Product
import com.example.e_commerce.R
import java.util.ArrayList

class StoreFrontFragment : Fragment() {

    val viewModel: StoreFrontViewModel by viewModels()
    val fragmentProductList:MutableList<StoreProductFragment> = ArrayList()
    lateinit var pagerAdapter: ProductViewPagerAdapter
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_store_front, container, false)
        viewModel.products.value?.let{
            pagerAdapter = ProductViewPagerAdapter(it, childFragmentManager)            
        }
        //root.productViewPager.adapter = pagerAdapter
       // val textView: TextView = root.findViewById(R.id.text_home)
            // homeViewModel.text.observe(viewLifecycleOwner, Observer {
      //      textView.text = it
            //})
        return root
    }

}

class ProductViewPagerAdapter(val products: List<Product>, fragmentManager: FragmentManager): FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getItem(position: Int): Fragment {
        return StoreProductFragment(products[position])
    }

    override fun getCount()= products.size
}
package com.example.e_commerce.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.e_commerce.R
import com.example.e_commerce.ui.ProductViewModel
import com.example.e_commerce.ui.StoreProductFragment
import kotlinx.android.synthetic.main.fragment_store_front.view.*
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
        pagerAdapter = ProductViewPagerAdapter()
        //root.productViewPager.adapter = pagerAdapter
       // val textView: TextView = root.findViewById(R.id.text_home)
            // homeViewModel.text.observe(viewLifecycleOwner, Observer {
      //      textView.text = it
            //})
        return root
    }
    inner class ProductViewPagerAdapter(): FragmentPagerAdapter(childFragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
        override fun getItem(position: Int): Fragment {
            return fragmentProductList[position]
        }

        override fun getCount()= viewModel.products.value!!.size
        }
    }

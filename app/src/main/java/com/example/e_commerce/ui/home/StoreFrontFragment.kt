package com.example.e_commerce.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.e_commerce.R

class StoreFrontFragment : Fragment() {

    private lateinit var homeViewModel: StoreFrontViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProviders.of(this).get(StoreFrontViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_store_front, container, false)
       // val textView: TextView = root.findViewById(R.id.text_home)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
      //      textView.text = it
        })
        return root
    }
}
package com.example.e_commerce.ui.dashboard

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.e_commerce.Adapters.CharacterItemDecoration
import com.example.e_commerce.Adapters.ProductsListAdapter
import com.example.e_commerce.Data.Product
//import com.example.e_commerce.Data.fillExampleProductsList
//import com.example.e_commerce.Data.products
import com.example.e_commerce.R
import kotlinx.android.synthetic.main.fragment_back_end.view.*

class BackEndFragment : Fragment(), ProductsListAdapter.Listener {

    //private lateinit var dashboardViewModel: BackEndViewModel
    lateinit var productsListAdapter: ProductsListAdapter
    lateinit var root: View
    val viewModel: BackEndViewModel by viewModels()
    //lateinit var products: List<Product>
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        root = inflater.inflate(R.layout.fragment_back_end, container, false)
        //fillExampleProductsList()
        root.productsListRecyclerView.layoutManager  = LinearLayoutManager(context)
        viewModel.products.observe(viewLifecycleOwner, Observer {
            productsListAdapter = ProductsListAdapter(viewModel.products.value, this)
            root.productsListRecyclerView.adapter =  productsListAdapter
        })
        root.productsListRecyclerView.addItemDecoration(CharacterItemDecoration(32))

        /*root.productsListRecyclerView.addItemDecoration(
            DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL).apply {
                //setDrawable(resources.getDrawable(R.drawable.divider, activity?.theme))
            }
        )*/
       // productsListAdapter = ProductsListAdapter(products)
       /* root.productsListRecyclerView.adapter =  productsListAdapter*/

        setHasOptionsMenu(true)
        return root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.top_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.addProductItem -> {
                val action = BackEndFragmentDirections.actionNavigationBackEndToProductFragment(null)
                findNavController().navigate(action)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onClickProduct(product: Product) {
        val action = BackEndFragmentDirections.actionNavigationBackEndToProductFragment(product.id)
        findNavController().navigate(action)
    }
}

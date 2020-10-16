package com.example.e_commerce.ui

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.e_commerce.Data.Product
//import com.example.e_commerce.Data.products
import com.example.e_commerce.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.product_fragment.view.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ProductFragment : Fragment() {

    companion object {
        fun newInstance() = ProductFragment()
    }

    val viewModel: ProductViewModel by viewModels()
    lateinit var root: View
    lateinit var product: Product
    val args: ProductFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        root=inflater.inflate(R.layout.product_fragment, container, false )
        setHasOptionsMenu(true)
        activity?.nav_view?.visibility = View.GONE
        if (args.productId == null) {

        } else {
            val temp = viewModel.products.value?.find {args.productId == it.id}
             if (temp!=null)
                product = temp
                root.editProductName.setText(product.name)
                root.editPrice.setText(product.price.toString())
                root.editAmount.setText(product.amount.toString())
            }

        return root}




   /* override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ProductViewModel::class.java)
        // TODO: Use the ViewModel
    }*/

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.save_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.saveItem -> {
                saveChanges()
            }
            android.R.id.home -> {
                findNavController().popBackStack()
            }
        }
        return true
    }

    private fun saveChanges() {
        if (args.productId == null) {
            val name = root.editProductName.text.toString()
            val price = root.editPrice.text.toString().toDouble()
            val amount = root.editAmount.text.toString().toInt()
            val product = Product(args.productId!!, name, price, amount)
            // products.add(product)
            /*fun insertProduct(product: Product) {
        GlobalScope.launch {
            localDB.productsDAO().insert(product)
        }
    }*/
            GlobalScope.launch {
                viewModel.insertProduct(product)
            }
            findNavController().popBackStack()
        } else {
            val name = root.editProductName.text.toString()
            val price = root.editPrice.text.toString().toDouble()
            val amount = root.editAmount.text.toString().toInt()
            val product = Product(args.productId!!, name, price, amount)
            GlobalScope.launch {
                viewModel.updateProduct(product)
            }
            findNavController().popBackStack()
        }
    }
}
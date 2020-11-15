package com.example.e_commerce.ui.AddEditProduct

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.e_commerce.Data.Product
//import com.example.e_commerce.Data.products
import com.example.e_commerce.R
import com.example.e_commerce.Util.setupSnackbar
import com.example.e_commerce.databinding.ProductFragmentBinding

import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class AddEditProductFragment : Fragment() {

    companion object {
        fun newInstance() =
            AddEditProductFragment()
    }

    private lateinit var viewDataBinding: ProductFragmentBinding
    val viewModel: AddEditProductViewModel by viewModels()
    lateinit var root: View
    lateinit var product: Product
    //val args: ProductFragmentArgs by navArgs()
    val args: AddEditProductFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel.setProductId(args.productId)
        root = inflater.inflate(R.layout.product_fragment, container, false)
        /*viewDataBinding = ProductFragmentBinding.bind(root).apply {
            viewmodel = viewModel
        }*/
        viewDataBinding = ProductFragmentBinding.bind(root)
        viewDataBinding.viewmodel = viewModel
        viewDataBinding.lifecycleOwner = this.viewLifecycleOwner
        setHasOptionsMenu(true)
        activity?.nav_view?.visibility = View.GONE
        viewModel.setProductId(args.productId)
        return viewDataBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupSnackbar()
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.save_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.saveItem -> {
                viewModel.saveChanges()
            }
            android.R.id.home -> {
                findNavController().popBackStack()
            }
        }
        return true
    }
    private fun setupSnackbar() {
        view?.setupSnackbar(this, viewModel.snackbarText, Snackbar.LENGTH_SHORT)
    }
}
 /*  private fun saveChanges() {
        if (args.productId == null) {
            val name = root.editProductName.text.toString()
            val price = root.editPrice.text.toString().toDouble()
            val amount = root.editAmount.text.toString().toInt()
            //val id:String = UUID.randomUUID().toString()
            val product = Product(name, price, amount)
            //val product = Product("", name, price, amount)
            // products.add(product)
            *//*fun insertProduct(product: Product) {
        GlobalScope.launch {
            localDB.productsDAO().insert(product)
        }
    }*//*
            GlobalScope.launch {
                viewModel.insertProduct(product)
            }
            findNavController().popBackStack()
        } else {
            val name = root.editProductName.text.toString()
            val price = root.editPrice.text.toString().toDouble()
            val amount = root.editAmount.text.toString().toInt()
            val product = Product(name, price, amount, args.productId!!)
            GlobalScope.launch {
                viewModel.updateProduct(product)
            }
            findNavController().popBackStack()
        }
    }
}*/
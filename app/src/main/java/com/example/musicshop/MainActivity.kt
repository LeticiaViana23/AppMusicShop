package com.example.musicshop

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.musicshop.adapter.ProductAdapter
import com.example.musicshop.databinding.ActivityMainBinding
import com.example.musicshop.listitems.Products
import com.example.musicshop.model.Product
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectIndexed
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var productAdapterSopro: ProductAdapter

    /*
    * Configuração para instrumentos de Sopro
    * */
    private val products = Products()
    private val productList: MutableList<Product> = mutableListOf()

    var clicked = false


    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.statusBarColor = Color.parseColor("#E0E0E0")
        /*
        * Instrumentos de Sopro
        * */
        CoroutineScope(Dispatchers.IO).launch {
            products.getProducts().collectIndexed { index, value ->
                for (p in value) {
                    productList.add(p)
                }
            }
        }

        val recyclerViewProducts = binding.recyclerViewProducts
        recyclerViewProducts.layoutManager = GridLayoutManager(this,2)
        recyclerViewProducts.setHasFixedSize(true)
        productAdapterSopro = ProductAdapter(this,productList)
        recyclerViewProducts.adapter = productAdapterSopro

        binding.btFind.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(text: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(text: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(text: Editable?) {
                filterNomeProducts(text.toString());
            }
        })


        binding.btAll.setOnClickListener {
            clicked = true
            if (clicked){
                binding.btAll.setBackgroundResource(R.drawable.bg_button_enabled)
                binding.btAll.setTextColor(Color.WHITE)
                binding.btCorda.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btCorda.setTextColor(R.color.white)
                binding.btSopro.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btSopro.setTextColor(R.color.white)
                binding.btEletro.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btEletro.setTextColor(R.color.white)
                filterProducts("all")
                binding.recyclerViewProducts.visibility = View.VISIBLE
                binding.txtListTitle.text = "All"
            }
        }

        binding.btCorda.setOnClickListener {
            clicked = true
            if (clicked){
                binding.btCorda.setBackgroundResource(R.drawable.bg_button_enabled)
                binding.btCorda.setTextColor(Color.WHITE)
                binding.btAll.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btAll.setTextColor(R.color.white)
                binding.btSopro.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btSopro.setTextColor(R.color.white)
                binding.btEletro.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btEletro.setTextColor(R.color.white)
                filterProducts("corda")
                binding.recyclerViewProducts.visibility = View.VISIBLE
                binding.txtListTitle.text = "Corda"
            }
        }

        binding.btSopro.setOnClickListener {
            clicked = true
            if (clicked){
                binding.btSopro.setBackgroundResource(R.drawable.bg_button_enabled)
                binding.btSopro.setTextColor(Color.WHITE)
                binding.btCorda.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btCorda.setTextColor(R.color.white)
                binding.btAll.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btAll.setTextColor(R.color.white)
                binding.btEletro.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btEletro.setTextColor(R.color.white)
                filterProducts("sopro")
                binding.recyclerViewProducts.visibility = View.VISIBLE
                binding.txtListTitle.text = "Sopro"
            }
        }

        binding.btEletro.setOnClickListener {
            clicked = true
            if (clicked){
                binding.btEletro.setBackgroundResource(R.drawable.bg_button_enabled)
                binding.btEletro.setTextColor(Color.WHITE)
                binding.btCorda.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btCorda.setTextColor(R.color.white)
                binding.btAll.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btAll.setTextColor(R.color.white)
                binding.btSopro.setBackgroundResource(R.drawable.bg_button_disabled)
                binding.btSopro.setTextColor(R.color.white)
                filterProducts("eletro")
                binding.recyclerViewProducts.visibility = View.VISIBLE
                binding.txtListTitle.text = "Eletro"
            }
        }


        }

    private fun filterProducts(tipo:String){

        if(tipo.equals("all")){
            productAdapterSopro = ProductAdapter(this,productList)
            binding.recyclerViewProducts.adapter = productAdapterSopro
        }else{
        val filterProducts = productList.filter { product ->
            product.tipo.contains(tipo, ignoreCase = true)
        }

        productAdapterSopro = ProductAdapter(this,filterProducts as MutableList<Product>)
        binding.recyclerViewProducts.adapter = productAdapterSopro
        }
    }

    private fun filterNomeProducts(nome:String){


            val filterProducts = productList.filter { product ->
                product.name.contains(nome, ignoreCase = true)
            }

            productAdapterSopro = ProductAdapter(this,filterProducts as MutableList<Product>)
            binding.recyclerViewProducts.adapter = productAdapterSopro

    }
}

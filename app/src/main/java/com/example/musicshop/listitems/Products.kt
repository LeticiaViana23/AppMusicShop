package com.example.musicshop.listitems

import com.example.musicshop.R
import com.example.musicshop.model.Product
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class Products {

    private val _productList = MutableStateFlow<MutableList<Product>>(mutableListOf())
    private val productListFlow: StateFlow<MutableList<Product>> = _productList

    fun  getProducts(): Flow<MutableList<Product>>{
        val productList: MutableList<Product> = mutableListOf(
            Product(
                imgProduct = R.drawable.flauta,
                name = "Flauta",
                price = "999.00"
            ),

            Product(
                imgProduct = R.drawable.trompete,
                name = "Trompete",
                price = "1099.00"
            ),

            Product(
                imgProduct = R.drawable.clarineta,
                name = "Clarineta",
                price = "1399.00"
            ),

            Product(
                imgProduct = R.drawable.saxofone,
                name = "Saxofone",
                price = "2299.00"
            ),
            Product(
                imgProduct = R.drawable.saxofone,
                name = "Saxofone Premium",
                price = "2599.00"
            ),
            Product(
                imgProduct = R.drawable.clarineta,
                name = "Clarineta Premium",
                price = "1599.00"
            )
        )
        _productList.value = productList
        return productListFlow
    }
}

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
                price = "999.00",
                tipo = "sopro"
            ),

            Product(
                imgProduct = R.drawable.trompete,
                name = "Trompete",
                price = "1099.00",
                tipo = "sopro"
            ),

            Product(
                imgProduct = R.drawable.clarineta,
                name = "Clarineta",
                price = "1399.00",
                tipo = "sopro"
            ),

            Product(
                imgProduct = R.drawable.saxofone,
                name = "Saxofone",
                price = "2299.00",
                tipo = "sopro"
            ),
            Product(
                imgProduct = R.drawable.saxofone,
                name = "Saxofone Premium",
                price = "2599.00",
                tipo = "sopro"
            ),
            Product(
                imgProduct = R.drawable.clarineta,
                name = "Clarineta Premium",
                price = "1599.00",
                tipo = "sopro"
            ),
            Product(
                imgProduct = R.drawable.guitarbranca,
                name = "Guitarra Branca",
                price = "1300.00",
                tipo = "corda"
            ),
            Product(
                imgProduct = R.drawable.guitarrapreta,
                name = "Guitarra Preta",
                price = "1300.00",
                tipo = "corda"
            ),
            Product(
                imgProduct = R.drawable.violao,
                name = "Violão",
                price = "900.00",
                tipo = "corda"
            ),
            Product(
                imgProduct = R.drawable.violino,
                name = "Violino",
                price = "660.00",
                tipo = "corda"
            ),
            Product(
                imgProduct = R.drawable.bateria_eletronica,
                name = "Bateria Eletrica",
                price = "2660.00",
                tipo = "eletro"
            ),
            Product(
                imgProduct = R.drawable.tecaldo,
                name = "Teclado",
                price = "1550.00",
                tipo = "eletro"
            )
        )
        _productList.value = productList
        return productListFlow
    }
}

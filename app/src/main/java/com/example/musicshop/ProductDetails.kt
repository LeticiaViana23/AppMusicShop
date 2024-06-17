package com.example.musicshop

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.musicshop.databinding.ActivityMainBinding
import com.example.musicshop.databinding.ActivityProductDetailsBinding
import java.text.DecimalFormat

class ProductDetails : AppCompatActivity() {

    private lateinit var  binding: ActivityProductDetailsBinding
    var amount = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.statusBarColor = Color.parseColor("#FFFFFF")

        val imgProduct = intent.extras!!.getInt("imgProduct")
        val name = intent.extras!!.getString("name")
        val price = intent.extras!!.getString("price")!!.toDouble()
        var newPrice = price
        val decimalFormat = DecimalFormat.getCurrencyInstance()

        binding.imgProduct.setBackgroundResource(imgProduct)
        binding.txtProductName.text = "$name"
        binding.txtPrice.text = decimalFormat.format(price)

        binding.btBack.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.btIncrease.setOnClickListener {
            if (amount ==  1){
                binding.txtAmount.text = "2"
                newPrice += price
                amount = 2
            } else if (amount == 2){
                binding.txtAmount.text = "3"
                newPrice += price
                amount = 3
            }
            binding.txtPrice.text = decimalFormat.format(newPrice)
        }
        binding.btDecrease.setOnClickListener {
            if (amount == 3){
                binding.txtAmount.text = "2"
                newPrice -= price
                amount = 2
            } else if (amount == 2){
                binding.txtAmount.text = "1"
                newPrice -= price
                amount = 1
            }
            binding.txtPrice.text = decimalFormat.format(newPrice)
        }
        binding.btConfirm.setOnClickListener {

            val intent = Intent(this,Payment::class.java)
            intent.putExtra("name",name)
            intent.putExtra("amount",amount)
            intent.putExtra("total",newPrice)
            startActivity(intent)
        }

    }
}
package com.example.musicshop

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.musicshop.databinding.ActivityPaymentBinding
import java.text.DecimalFormat

class Payment : AppCompatActivity() {

    private lateinit var binding: ActivityPaymentBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaymentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //color StatusBar
        window.statusBarColor = Color.parseColor("#E0E0E0")

        val name = intent.extras!!.getString("name")
        val amount = intent.extras!!.getInt("amount")
        val total = intent.extras!!.getDouble("total")
        val decimalFormat = DecimalFormat.getCurrencyInstance()

        binding.txtTotal.text = "$name \n Amount: $amount \n Total: ${decimalFormat.format(total)}"

        binding.btPay.setOnClickListener {
            if (binding.btCreditCard.isChecked){
                val intent = Intent(this,ThankYouScreen::class.java)
            startActivity(intent)
            Toast.makeText(this,"Pagamento com Cartão",Toast.LENGTH_SHORT).show()
            }else if (binding.btPix.isChecked){
                binding.editPix.visibility = View.VISIBLE
                val  pix = binding.editPix.text.toString()

                if (pix.isNotEmpty()){
                    val  intent = Intent(this,ThankYouScreen::class.java)
                    intent.putExtra("userPix",pix)
                    startActivity(intent)
                    Toast.makeText(this,"Pagamento com Pix",Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this,"Preencha o campo Pix",Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}


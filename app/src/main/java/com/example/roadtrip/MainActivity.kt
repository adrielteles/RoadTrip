package com.example.roadtrip

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.roadtrip.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCalculate.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if (view.id == R.id.button_calculate){
             calculate()
        }
    }

    private fun validateFloatInput(input: String): Boolean {

        if (input.replace(" ", "") != "" && input.toFloatOrNull() != null && input.toFloat() > 0) {
            return true
        }
        return false
    }

    private fun calculate() {
        val distance = binding.editDistance.text.toString()
        val price = binding.editPriceFuel.text.toString()
        val autonomy = binding.editAutonomy.text.toString()

        var totalValue = 0F

        if (validateFloatInput(distance) && validateFloatInput(price) && validateFloatInput(autonomy)) {
            totalValue = (distance.toFloat() * price.toFloat()) / autonomy.toFloat()
        } else {
            Toast.makeText(this, R.string.validate_fill_all_fields, Toast.LENGTH_SHORT).show()
        }


        val stringTotalValue = "R$ ${String.format("%.2f", totalValue)}"
        binding.textTotalValue.text = stringTotalValue
    }


}

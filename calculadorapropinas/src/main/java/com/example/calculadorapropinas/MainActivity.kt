package com.example.calculadorapropinas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.calculadorapropinas.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttoncalculate.setOnClickListener{
            calcularPropina()
        }
    }

    private fun calcularPropina(){
        if(binding.dtCostofService.text.isEmpty()) {
            Toast.makeText(this, "Introduzca propina", Toast.LENGTH_LONG).show()
            return
        }
        val stringPropina = binding.dtCostofService.text.toString()
        val propina = stringPropina.toDouble()
        val porcentaje = when ( binding.tipOptions.checkedRadioButtonId){
            R.id.option_eighteen_percent -> 0.18
            R.id.option_twenty_percent -> 0.20
            else -> 0.15
        }
        var tip = propina * porcentaje
        if(binding.roundUpSwitch.isChecked){
            tip = kotlin.math.ceil(tip)
        }
        val formatoMoneda = NumberFormat.getCurrencyInstance().format(tip)
        binding.tipAmount.text = getString(R.string.tip_amount,formatoMoneda)

        }
    }

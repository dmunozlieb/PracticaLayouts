package com.example.generardado

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val buttonRoll: Button = findViewById(R.id.generarRoll)
       val imageDado: ImageView = findViewById(R.id.imagenDado)
        buttonRoll.setOnClickListener{
            generarDado(imageDado)
        }
    }

    fun generarDado(imageDado: ImageView){
        val firstDice = Dice(6)
        val numLado: Int = firstDice.roll()
       when (numLado){
           1 -> imageDado.setImageResource(R.drawable.dice_1)
           2 -> imageDado.setImageResource(R.drawable.dice_2)
           3 -> imageDado.setImageResource(R.drawable.dice_3)
           4 -> imageDado.setImageResource(R.drawable.dice_4)
           5 -> imageDado.setImageResource(R.drawable.dice_5)
           6 -> imageDado.setImageResource(R.drawable.dice_6)
           else ->
               Toast.makeText(this,"Solo se admite un dado de 6 caras",Toast.LENGTH_LONG)
       }

        imageDado.contentDescription = numLado.toString()
    }

    class Dice(val sides: Int){
        fun roll(): Int{
            return (1..sides).random()
        }
    }

}
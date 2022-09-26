package com.reyndev.diceroll

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btnRoll: Button = findViewById(R.id.btnRoll)
        btnRoll.setOnClickListener {
            rollDice()
        }
    }

    private fun rollDice() {
        val ivDice: ImageView = findViewById(R.id.ivDice)

        val dice = Dice(6)
        val rollResult = dice.roll()

        val diceImages = when (rollResult) {
            2 ->R.drawable.dice_02
            1 ->R.drawable.dice_01
            3 ->R.drawable.dice_03
            4 ->R.drawable.dice_04
            5 ->R.drawable.dice_05
            else ->R.drawable.dice_06
        }
        ivDice.setImageResource(diceImages)

        if (rollResult.equals(5)) {
            Toast.makeText(this, "Anda beruntung!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Anda belum beruntung", Toast.LENGTH_SHORT).show()
        }
    }
}

class Dice(private val sides: Int) {
    fun roll(): Int {
        return (1..sides).random()
    }
}
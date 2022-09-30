package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var rollButton: Button = findViewById(R.id.button);
        rollButton.setOnClickListener { rollDice(); };

        rollDice();
    }

    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice() {
        var diceRoll: Int = Dice(6).roll();
        val diceImage: ImageView = findViewById(R.id.imageView);

        val drawableResource: Int = when(diceRoll){
            1 -> R.drawable.dice_1;
            2 -> R.drawable.dice_2;
            3 -> R.drawable.dice_3;
            4 -> R.drawable.dice_4;
            5 -> R.drawable.dice_5;
            else -> R.drawable.dice_6;
        }
        diceImage.setImageResource(drawableResource);
        diceImage.contentDescription = diceRoll.toString();
    }
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random();
    }
}
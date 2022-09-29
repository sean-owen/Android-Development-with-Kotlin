package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
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
    }

    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice() {
        val dice1ResultTextView: TextView = findViewById(R.id.dice1Result);
        dice1ResultTextView.text = Dice(6).roll().toString();

        val dice2ResultTextView: TextView = findViewById(R.id.dice2Result);
        dice2ResultTextView.text = Dice(6).roll().toString();
    }
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random();
    }
}
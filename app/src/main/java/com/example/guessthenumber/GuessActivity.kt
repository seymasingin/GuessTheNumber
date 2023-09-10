package com.example.guessthenumber

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.guessthenumber.databinding.ActivityGuessBinding
import kotlin.random.Random

class GuessActivity : AppCompatActivity() {

    private lateinit var bindingGuess : ActivityGuessBinding

    private var randomNumber =0
    private var counter = 5

    override fun onCreate(savedInstanceState: Bundle?) {
        bindingGuess = ActivityGuessBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(bindingGuess.root)

        randomNumber = Random.nextInt(101) // 0 ie 100 arasında

        Log.e("Random Number: ", randomNumber.toString())

        bindingGuess.buttonGuess.setOnClickListener {

            val guess = bindingGuess.inputs.text.toString().toInt()
            counter = counter - 1

            if (guess == randomNumber) {
                val intent =Intent(applicationContext, ResultActivity::class.java)
                intent.putExtra("result", true)
                finish()
                startActivity(intent)
                return@setOnClickListener
            }

            if (guess > randomNumber) {
                bindingGuess.help.text = "Decrease"
                bindingGuess.chances.text = "Chances: + $counter"
            }
            if (guess < randomNumber) {
                bindingGuess.help.text = "Increase"
                bindingGuess.chances.text = "Chances: + $counter"
            }
            if (counter == 0) {
                val intent =Intent(applicationContext, ResultActivity::class.java)
                intent.putExtra("result", false)
                finish()
                startActivity(intent)
            }
            bindingGuess.inputs.setText("")
        }
}}
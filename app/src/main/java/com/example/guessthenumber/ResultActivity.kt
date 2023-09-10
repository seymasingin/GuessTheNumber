package com.example.guessthenumber

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.guessthenumber.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var bindingResult : ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        bindingResult = ActivityResultBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(bindingResult.root)

        val result = intent.getBooleanExtra("result", false)

        if (result){
            bindingResult.resultText.text = "You Won"
            bindingResult.face.setImageResource(R.drawable.happy)
        }
        else{
            bindingResult.resultText.text = "You Lost"
            bindingResult.face.setImageResource(R.drawable.sad)

        }

        bindingResult.buttonAgain.setOnClickListener {
            val intent = Intent(applicationContext,GuessActivity::class.java)
            finish()
            startActivity(intent)
        }
    }
}
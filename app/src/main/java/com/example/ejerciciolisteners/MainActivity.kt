package com.example.ejerciciolisteners

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.view.isVisible
import androidx.core.widget.doAfterTextChanged

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var b1 = findViewById<Button>(R.id.boton1)
        var et1 = findViewById<EditText>(R.id.et1)
        var aM = findViewById<LinearLayout>(R.id.AcMain)
        var bat = findViewById<ImageView>(R.id.batman)
        var clicks = 0;

        b1.setOnClickListener {
            clicks++
            if(clicks%2!=0) {
                et1.isEnabled = true
                et1.isVisible = true
                b1.text = "FINALIZAR"
                et1.addTextChangedListener(object : TextWatcher {
                    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    }

                    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    }

                    override fun afterTextChanged(p0: Editable?) {
                        if (p0 != null) {
                            if (p0.contains("Wayne")) {
                                aM.setBackgroundColor(Color.YELLOW)
                                et1.setTextColor(Color.BLACK)
                                b1.setBackgroundColor(Color.BLACK)
                                b1.setTextColor(Color.YELLOW)
                                bat.isVisible = true
                            } else {
                                if (p0.contains("joker")) {
                                    aM.setBackgroundColor(Color.GREEN)
                                    et1.setTextColor(Color.MAGENTA)
                                    b1.setBackgroundColor(Color.MAGENTA)
                                    b1.setTextColor(Color.GREEN)
                                    bat.isVisible = false
                                }
                            }
                        }
                    }
                })
            }else{
                et1.isEnabled = false
                et1.isVisible = false
                et1.text.clear()
                aM.setBackgroundColor(Color.parseColor("#C8A187"))
                et1.setBackgroundColor(Color.BLACK)
                et1.setTextColor(Color.WHITE)
                bat.isVisible = false
                b1.text = "COMENZAR"
                b1.setTextColor(Color.WHITE)
                b1.setBackgroundColor(Color.BLACK)
            }
        }
    }
}
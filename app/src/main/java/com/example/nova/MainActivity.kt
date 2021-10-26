package com.example.nova

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.nova.models.Persona

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val a = Persona("", "", 180)
        val b = Persona("", "")
        val c = Persona("", "", 190)
        val d = Persona("", "", -25)


        findViewById<TextView>(R.id.myText).text = a.cuantoMide()
    }
}
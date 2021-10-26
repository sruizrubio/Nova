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

        findViewById<TextView>(R.id.myText).text = contar1().toString()
    }

    fun contar1(): Int {

        var suma = 0
        for (i in 1..10) {
            suma+=i
        }
        return suma
    }

    fun contar2(): Int{
        var suma = 0
        for (i in 1..10) {
            suma += i
            if (i >= 6)
                break
        }
        return suma
    }

    fun contar3(): Int {
        var suma = 0
        for (i in 1 until 10) {
            suma+=i
        }
        return suma
    }

    fun contar4(): Int{
        var suma = 0
        var count = 0
        while(count < 3) {
            for (i in 1..10) {
                suma += i
            }
            count++
        }
        return suma
    }

    fun foreach(){
        val list: List<String> = listOf()
        list.forEach {
            if(list.indexOf(it) == 2)
                return@forEach
        }
    }
}
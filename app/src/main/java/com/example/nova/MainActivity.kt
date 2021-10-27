package com.example.nova

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.example.nova.models.Persona
import com.example.nova.models.media
import com.example.nova.models.notaFinal

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.myText).text = resultadosALumnos()
    }

    private fun resultadosALumnos(): String {
        val alumnos = listOf(
            Persona("a", "A", notas = mutableListOf(-11.0, -2.0, -5.0)),
            Persona("b", "B", notas = mutableListOf(11.0, 12.0, 15.0)),
            Persona("c", "C", notas = mutableListOf(2.0, 3.0, 4.0)),
            Persona("d", "D", notas = mutableListOf(5.0, 6.0, 7.0)),
            Persona("e", "E", notas = mutableListOf(7.0, 7.5, 8.0)),
            Persona("f", "F", notas = mutableListOf(8.0, 9.0, 10.0)),
            Persona("g", "G", notas = mutableListOf(2.5, 8.0, 5.5)),
            Persona("h", "H", notas = mutableListOf(4.0, 0.0, 9.0)),
            Persona("i", "I", notas = mutableListOf(4.5, 8.5, 7.7)),
            Persona("j", "J", notas = mutableListOf())
        )

        var resultados = ""

        alumnos.forEach { resultados += it.getNombre() + " " + it.getApellido() + " - " +
                it.media() + ": " + it.notaFinal() + "\n" }

        return resultados
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
package com.example.nova.models

import java.text.DecimalFormat

class Persona(private val nombre: String, private val apellido: String,
              private var altura: Int? = null,
              private var notas: MutableList<Double> = mutableListOf(),
              private var oficio: String? = null, private var hobbie: String? = null) {

    fun getNombre(): String {
        return nombre
    }

    fun getApellido(): String {
        return apellido
    }

    fun getNotas(): MutableList<Double> {
        return notas
    }

    fun cuantoMide(): String {
        return altura?.let {

            if (it <= 0)
                "La altura no es válida"
            else if (it <= 180)
                "La persona mide 180 cm o menos"
            else
                "La persona mide más de 180 cm"

        } ?: "La persona no tiene guardada su altura"
    }

}

fun Persona.media(): Double {
    val media: Double
    val notas = getNotas()

    if (notas.isEmpty())
        media = Double.NaN
    else {
        var sumaNotas = 0.0
        notas.forEach {
            sumaNotas += it
        }

        media = DecimalFormat("0.00").format(sumaNotas / notas.size).toDouble()
    }

    return media
}

fun Persona.notaFinal(): String {
    val resultado: String
    val media = this.media()

    resultado = if (media.isNaN())
        "La persona no tiene notas"
    else {
        when(media >= 0) {
            media < 5 -> "Suspenso"

            media <= 8 -> "Aprobado"

            media <= 10 -> "Sobresaliente"

            else -> "Nota inválida"
        }
    }

    return resultado
}

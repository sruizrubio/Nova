package com.example.nova.models

class Persona(private val nombre: String, private val apellido: String,
              private var altura: Int? = null, private var oficio: String? = null,
              private var hobbie: String? = null) {

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

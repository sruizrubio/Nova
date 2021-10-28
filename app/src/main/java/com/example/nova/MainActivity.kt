package com.example.nova

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nova.adapters.MyAdapter
import com.example.nova.adapters.MyListAdapter
import com.example.nova.databinding.ActivityMainBinding
import com.example.nova.models.Persona
import com.example.nova.models.media
import com.example.nova.models.notaFinal

class MainActivity : AppCompatActivity() {

    var _binding: ActivityMainBinding? = null
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        savedInstanceState?.getString("nombrePersona")

        _binding = ActivityMainBinding.inflate(layoutInflater)
        binding = _binding!!

        setContentView(binding.root)

        binding.apply {
            myText.text = resultadosALumnos()

            val myList = mutableListOf("1","2","3","4","5","6","7","8","9","10")

            myRecyclerView.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
//                var adapter = MyAdapter(myList)
                var adapter = MyListAdapter()
            myRecyclerView.adapter = adapter
            adapter.submitList(myList)

            myText.setOnClickListener {
                val intent = Intent(applicationContext, LoginActivity::class.java)
                intent.putExtra("nombrePersona", "nombre1")
                startActivity(intent)
            }
        }
        this.finish()
    }

    private fun resultadosALumnos(): String {
        val alumnos = listOf(
            Persona("a", "A", notas = mutableListOf(10.0, 2.0, 5.0)),
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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
    }

    override fun onRestart() {
        super.onRestart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
package com.example.examenmultimedia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.examenmultimedia.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var tituloP =""
        var duracionP =""
        var intentMovie = Intent(this,MovieDetails::class.java)
        binding.button.setOnClickListener(){
            tituloP=binding.editTextTextTitulo.text.toString()
            duracionP=binding.editTextTextDuracion.text.toString()
            intentMovie.putExtra("Titulo",tituloP)
            intentMovie.putExtra("Duracion",duracionP)
            startActivity(intentMovie)

        }

    }
}
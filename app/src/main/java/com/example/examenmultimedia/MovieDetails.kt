package com.example.examenmultimedia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.examenmultimedia.databinding.ActivityMainBinding
import com.example.examenmultimedia.databinding.ActivityMovieDetailsBinding

class MovieDetails : AppCompatActivity() {
    lateinit var binding: ActivityMovieDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMovieDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var tituloP =intent.getStringExtra("Titulo")
        var duracionP =intent.getStringExtra("Duracion")
        var directorP =""
        var lanzamientoP =""
        var intentDisplay = Intent(this,MovieDisplay::class.java)
        var intentMain = Intent(this,MainActivity::class.java)

        binding.button.setOnClickListener(){
            directorP=binding.editTextTextDirector.text.toString()
            lanzamientoP=binding.editTextTextLanzamiento.text.toString()
            intentDisplay.putExtra("Titulo",tituloP)
            intentDisplay.putExtra("Duracion",duracionP)
            intentDisplay.putExtra("Director",tituloP)
            intentDisplay.putExtra("Lanzamiento",lanzamientoP)

            startActivity(intentDisplay)

        }
        binding.buttonBack.setOnClickListener(){
            startActivity(intentMain)
        }

    }
}
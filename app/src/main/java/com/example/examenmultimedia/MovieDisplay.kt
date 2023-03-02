package com.example.examenmultimedia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.examenmultimedia.databinding.ActivityMainBinding
import com.example.examenmultimedia.databinding.ActivityMovieDetailsBinding
import com.example.examenmultimedia.databinding.ActivityMovieDisplayBinding

class MovieDisplay : AppCompatActivity() {
    lateinit var binding: ActivityMovieDisplayBinding
    var cont=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMovieDisplayBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var tituloP =intent.getStringExtra("Titulo").toString()
        var duracionP =intent.getStringExtra("Duracion").toString()
        var directorP =intent.getStringExtra("Director").toString()
        var lanzamientoP =intent.getStringExtra("Lanzamiento").toString()
        agregarPeli(tituloP,duracionP,directorP,lanzamientoP)
        verPelis()
        var intentMovie = Intent(this,MovieDetails::class.java)
        binding.buttonBack.setOnClickListener(){
            startActivity(intentMovie)
        }
        binding.buttonLimpiarTodo.setOnClickListener(){
            clearpelis()
            verPelis()
        }
        binding.buttonLimpiarConcreto.setOnClickListener(){
            clearpeli(binding.editTextEliminarPeli.text.toString())
            verPelis()
        }

    }
    fun verPelis(){
        cont=0
        peliculas.forEach {
            if (cont==0){
                binding.textViewTitulo1.setText(it.titulo)
                binding.textViewDuracion1.setText(it.duracion)
                binding.textViewDirector1.setText(it.director)
                binding.textViewLanzamiento1.setText(it.lanzamiento)
            }
            else if (cont==1){
                binding.textViewTitulo2.setText(it.titulo)
                binding.textViewDuracion2.setText(it.duracion)
                binding.textViewDirector2.setText(it.director)
                binding.textViewLanzamiento2.setText(it.lanzamiento)
            }
            else if (cont==2){
                binding.textViewTitulo3.setText(it.titulo)
                binding.textViewDuracion3.setText(it.duracion)
                binding.textViewDirector3.setText(it.director)
                binding.textViewLanzamiento3.setText(it.lanzamiento)
            }

        }
    }
    companion object{
        var contador=0
        var peliculas= mutableListOf<Movie>()
        fun agregarPeli(titulo:String,duracion:String,director:String,lanzamiento:String){
            peliculas.add(Movie(titulo,duracion,director,lanzamiento))
        }
        fun clearpelis(){
            peliculas.clear()
        }
        fun clearpeli(tituloB:String){
            peliculas.removeIf {
                it.titulo==tituloB
            }
        }
    }
}
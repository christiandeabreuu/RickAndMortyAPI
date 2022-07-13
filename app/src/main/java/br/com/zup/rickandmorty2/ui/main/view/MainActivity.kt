package br.com.zup.rickandmorty2.ui.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.zup.rickandmorty2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }


}
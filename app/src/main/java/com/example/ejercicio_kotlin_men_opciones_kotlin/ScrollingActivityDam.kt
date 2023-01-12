package com.example.ejercicio_kotlin_men_opciones_kotlin

import android.content.Intent
import android.os.Bundle
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.example.ejercicio_kotlin_men_opciones_kotlin.databinding.ActivityScrollingDamBinding

class ScrollingActivityDam : AppCompatActivity() {

    private lateinit var binding: ActivityScrollingDamBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityScrollingDamBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(findViewById(R.id.toolbar))
        binding.toolbarLayout.title = "CFGS DAM"
        binding.fab.setOnClickListener { view ->
            startActivity(Intent(this, MainActivity::class.java).apply {  })

        }
    }
}
package com.example.ejercicio_kotlin_men_opciones_kotlin

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import com.example.ejercicio_kotlin_men_opciones_kotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)
        /*
        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

         */
    }

    //Menu toolbar
    /*
        Para especificar el menú de opciones para una actividad, invalide onCreateOptionsMenu()
        (los fragmentos proporcionan su propia onCreateOptionsMenu() devolución de llamada).
        En este método, puede inflar su recurso de menú ( definido en XML ) en el Menu proporcionado en la devolución de llamada.
     */
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }


    /*
    Cuando se selecciona un elemento verificable, el sistema llama al método de devolución de llamada correspondiente
    al elemento seleccionado (como onOptionsItemSelected()). Es aquí donde debe establecer el estado de la casilla de
    verificación, porque una casilla de verificación o un botón de radio no cambia su estado automáticamente.
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //devulve el item pulsado
        return when (item.itemId) {

            R.id.menuAsir -> {
                startActivity(
                    Intent(
                        this,
                        ScrollingActivityAsir::class.java
                    ).apply { })//se ejecuta ScrollingActivityAsir

                true

            }
            R.id.menuDaw -> {
                startActivity(
                    Intent(
                        this,
                        ScrollingActivityDaw::class.java
                    ).apply { })//se ejecuta ScrollingActivityDaw

                true

            }
            R.id.menuDam -> {
                startActivity(
                    Intent(
                        this,
                        ScrollingActivityDam::class.java
                    ).apply { })//se ejecuta ScrollingActivityDam

                true

            }


            else -> super.onOptionsItemSelected(item)
        }


    }


    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}
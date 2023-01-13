package com.example.ejercicio_kotlin_men_opciones_kotlin

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.ejercicio_kotlin_men_opciones_kotlin.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /*
        Vamos a añadir en primer lugar un menú contextual que aparezca al pulsar s
        obre la etiqueta de texto. Para ello, lo primero que vamos a hacer es indicar
        en el método onCreateView() de nuestro fragment principal que la etiqueta tendrá
         */
        registerForContextMenu(binding.imageView7)
        registerForContextMenu(binding.imageView8)
        registerForContextMenu(binding.imageView9)


    }

    //Menu pulsado
    /*
    A continuación, igual que hacíamos con onCreateOptionsMenu() para los menús básicos,
    vamos a sobreescribir en nuestra actividad el evento encargado de construir los menús
    contextuales asociados a los diferentes controles de la aplicación. En este caso el evento
    se llama onCreateContextMenu(), y a diferencia de onCreateOptionsMenu() éste se llama cada vez
    que se necesita mostrar un menú contextual, y no una sola vez al inicio de la aplicación.
     */
    override fun onCreateContextMenu(
        menu: ContextMenu, v: View, menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        if (menu != null) {
            if (v != null) {
                super.onCreateContextMenu(menu, v, menuInfo)
            }
        }
        //val inflater: MenuInflater = menuInflater
        activity?.menuInflater?.inflate(R.menu.menu_main, menu)
    }

    /*
        A continuación, igual que hacíamos con onCreateOptionsMenu() para los menús básicos,
        vamos a sobreescribir en nuestra actividad el evento encargado de construir los menús
        contextuales asociados a los diferentes controles de la aplicación. En este caso el evento
        se llama onContextItemSelected(), y a diferencia de onCreateOptionsMenu() éste se llama cada vez
         que se necesita mostrar un menú contextual, y no una sola vez al inicio de la aplicación.
         */
    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {

            R.id.menuAsir -> {
                startActivity(
                    Intent(
                        activity,
                        ScrollingActivityAsir::class.java
                    ).apply { })//ejecuta ScrollingActivityAsir

                true

            }
            R.id.menuDaw -> {
                startActivity(
                    Intent(
                        activity,
                        ScrollingActivityDaw::class.java
                    ).apply { })//ejecuta ScrollingActivityDaw

                true

            }
            R.id.menuDam -> {
                startActivity(
                    Intent(
                        activity,
                        ScrollingActivityDam::class.java
                    ).apply { })//ejecuta ScrollingActivityDam

                true

            }


            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
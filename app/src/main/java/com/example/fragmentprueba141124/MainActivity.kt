package com.example.fragmentprueba141124

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity() {
    val bundle=Bundle()
    var fragment=FragmentBotones({btn->onClickBoton(btn)})

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        cargarFragment(fragment)
    }

    private fun cargarFragment(fragment:Fragment) {

        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace(R.id.fcv_menu,fragment)
        }
    }

    private fun onClickBoton(btn : Int){
        Toast.makeText(this, "Pulsado el boton: $btn", Toast.LENGTH_SHORT).show()
        bundle.putInt("BOTON", btn)
        fragment=FragmentBotones({btn->onClickBoton(btn)}).apply {
            arguments=bundle
        }
        cargarFragment(fragment)
    }
}
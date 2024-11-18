package com.example.fragmentprueba141124

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button



class FragmentBotones(private val onClickBoton: (Int)->Unit) : Fragment() {

    private val botones= arrayOf(R.id.btn_1, R.id.btn_2, R.id.btn_3)
    var boton=100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        boton = arguments?.getInt("BOTON") ?: -1

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_botones, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val colorSeleccionado = ColorStateList.valueOf(Color.parseColor("#FF8000"))
        var btnView: Button
        for(i in botones.indices){
            btnView=view.findViewById(botones[i])
            if(boton==i){
                btnView.backgroundTintList= colorSeleccionado
            }
            btnView.setOnClickListener {
                onClickBoton(i)
            }

        }

    }
}
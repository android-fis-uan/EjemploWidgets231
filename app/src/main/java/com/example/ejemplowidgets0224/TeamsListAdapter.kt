package com.example.ejemplowidgets0224

import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class TeamsListAdapter(val ctx: MainActivity, val layout: Int, val data: List<String>)
    : ArrayAdapter<String>(ctx, layout, data){

    // este metodo se llama por cada elemento del arreglo de datos
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val container = ctx.layoutInflater.inflate(layout, null)
        // cambiar el nombre del equipo para este elemnto de la lista
        val teamName = container.findViewById<TextView>(R.id.teamName)
        teamName.text = data[position]
        // cambiar la imagen para este elemtno de la lista
        val id = ctx.resources.getIdentifier(data[position].lowercase(), "drawable", ctx.packageName) // R.drawable.teanName
        val teamIcon = container.findViewById<ImageView>(R.id.teamIcon)
        teamIcon.setImageResource(id)
        return container
    }

}
package com.example.ejemplowidgets0224

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import com.example.ejemplowidgets0224.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding
    val teamNames = arrayListOf<String>("Liverpool","Manchester")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.imgTeamShield.setImageResource(R.drawable.bart)
        binding.btnLiverpool.setOnClickListener { changeTeamFlag("liverpool") }
        binding.btnManchester.setOnClickListener { changeTeamFlag("manchester") }
        binding.rdbLiverpool.setOnClickListener { changeTeamFlag("liverpool") }
        binding.rdbManchester.setOnClickListener { changeTeamFlag("manchester") }
        binding.switchTeam.setOnClickListener {
            if(binding.switchTeam.isChecked)
                changeTeamFlag("liverpool")
            else
                changeTeamFlag("manchester")
        }
        // conectar la lista con el arreglo de datos usando un adaptador
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, teamNames )
        binding.teamsList.adapter = adapter
        binding.teamsList.setOnItemClickListener { list, view, position, id -> // lambda
            println( "list: $list \n" +
                    "view: $view \n" +
                    "position: $position \n" +
                    "id: $id")
            val tv = view as TextView
            changeTeamFlag(tv.text.toString().lowercase())
        }
    }

    fun changeTeamFlag(teamName:String) {
        val id = resources.getIdentifier(teamName, "drawable", packageName) // R.drawable.teanName
        binding.imgTeamShield.setImageResource(id)
    }
}
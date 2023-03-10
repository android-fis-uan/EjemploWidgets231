package com.example.ejemplowidgets0224

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import com.example.ejemplowidgets0224.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding
    lateinit var adapter:TeamsListAdapter
    val teamNames = arrayListOf<String>("Liverpool","Manchester")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        println(intent)
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
        adapter = TeamsListAdapter(this, R.layout.list_teams, teamNames )
        binding.teamsList.adapter = adapter
        binding.teamsList.setOnItemClickListener { list, view, position, id -> // lambda
            println( "list: $list \n" +
                    "view: $view \n" +
                    "position: $position \n" +
                    "id: $id")
            //changeTeamFlag(teamNames[position].lowercase())
            openTeamInfoActivity(teamNames[position])
        }
    }

    fun changeTeamFlag(teamName:String) {
        val id = resources.getIdentifier(teamName, "drawable", packageName) // R.drawable.teanName
        binding.imgTeamShield.setImageResource(id)
        teamNames.add("Otro equipo")
        adapter.notifyDataSetChanged()
    }

    fun openTeamInfoActivity(teamName: String) {
        val teamInfoIntent = Intent( this, InfoEquipoActivity::class.java)
        teamInfoIntent.putExtra("TEAM_NAME", teamName)
        startActivity(teamInfoIntent)
    }
}
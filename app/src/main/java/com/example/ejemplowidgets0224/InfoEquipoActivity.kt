package com.example.ejemplowidgets0224

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class InfoEquipoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_equipo)
        val team = intent.getSerializableExtra("TEAM_DATA") as TeamInfo
        val textView = findViewById<TextView>(R.id.teamName)
        textView.text = team.name
        val originText = findViewById<TextView>(R.id.teamOrigin)
        originText.text = "${team.country}, ${team.founded}"
        val flagImage = findViewById<ImageView>(R.id.teamFlag)
        flagImage.setImageResource(team.flag)
    }
}
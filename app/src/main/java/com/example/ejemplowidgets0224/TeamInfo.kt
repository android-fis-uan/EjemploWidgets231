package com.example.ejemplowidgets0224

data class TeamInfo(
    val name:String,
    val flag:Int, // referencia un identificador recurso (R.*)
    val country:String,
    val founded:String
) {
}
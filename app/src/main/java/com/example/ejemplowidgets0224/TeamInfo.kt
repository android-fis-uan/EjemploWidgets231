package com.example.ejemplowidgets0224

import java.io.Serializable

data class TeamInfo(
    val name:String,
    val flag:Int, // referencia un identificador recurso (R.*)
    val country:String,
    val founded:String,
    val webpage: String,
    val stadiumLocation:String="geo:53.4308326,-2.9630187?z=17"
) : Serializable {
}
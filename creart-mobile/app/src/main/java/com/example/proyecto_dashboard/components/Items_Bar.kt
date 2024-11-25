package com.example.proyecto_dashboard.components

import com.example.proyecto_dashboard.R

//Se incializan las variables para el menu del footer
sealed class Items_Bar(
    val icon: Int,
    val title: String,
    val ruta: String
) {
    object  Boton2: Items_Bar(R.drawable.cerrarsecion2, "Cerrar", "boton2")
    object  Boton4: Items_Bar(R.drawable.ic_location_24, "Sucursales", "boton4")
}

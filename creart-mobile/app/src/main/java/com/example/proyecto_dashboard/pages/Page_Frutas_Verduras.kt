package com.example.proyecto_dashboard.pages

import android.content.Context
import android.graphics.BitmapFactory
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.proyecto_dashboard.R
import com.example.proyecto_dashboard.R.string.Oleo1
import com.example.proyecto_dashboard.R.string.canva
import com.example.proyecto_dashboard.R.string.detalles1
import com.example.proyecto_dashboard.R.string.detalles10
import com.example.proyecto_dashboard.R.string.detalles11
import com.example.proyecto_dashboard.R.string.detalles12
import com.example.proyecto_dashboard.R.string.detalles13
import com.example.proyecto_dashboard.R.string.detalles14
import com.example.proyecto_dashboard.R.string.detalles15
import com.example.proyecto_dashboard.R.string.detalles2
import com.example.proyecto_dashboard.R.string.detalles3
import com.example.proyecto_dashboard.R.string.detalles4
import com.example.proyecto_dashboard.R.string.detalles5
import com.example.proyecto_dashboard.R.string.detalles6
import com.example.proyecto_dashboard.R.string.detalles7
import com.example.proyecto_dashboard.R.string.detalles8
import com.example.proyecto_dashboard.R.string.detalles9
import com.example.proyecto_dashboard.R.string.detallesc1
import com.example.proyecto_dashboard.R.string.detallesc10
import com.example.proyecto_dashboard.R.string.detallesc11
import com.example.proyecto_dashboard.R.string.detallesc12
import com.example.proyecto_dashboard.R.string.detallesc13
import com.example.proyecto_dashboard.R.string.detallesc14
import com.example.proyecto_dashboard.R.string.detallesc15
import com.example.proyecto_dashboard.R.string.detallesc2
import com.example.proyecto_dashboard.R.string.detallesc3
import com.example.proyecto_dashboard.R.string.detallesc4
import com.example.proyecto_dashboard.R.string.detallesc5
import com.example.proyecto_dashboard.R.string.detallesc6
import com.example.proyecto_dashboard.R.string.detallesc7
import com.example.proyecto_dashboard.R.string.detallesc8
import com.example.proyecto_dashboard.R.string.detallesc9
import com.example.proyecto_dashboard.components.CreateChannelNotification
import com.example.proyecto_dashboard.components.notificacionImagen

@Composable
fun Page_Frutas_Verduras(modifier: Modifier = Modifier) {
    var selectedProduct by remember { mutableStateOf<DrawableStringPairFlores2?>(null) }

    val idNotification: Int = 0
    val context: Context = LocalContext.current
    val idChannel: String = stringResource(R.string.canal_tienda)
    val name = stringResource(R.string.canal_tienda)
    val descriptionText = stringResource(R.string.canal_notificaciones)

    val textLong: String = "Bienvenido a catalogo " +
            "Oleos"

    val imagenBig = BitmapFactory.decodeResource(
        context.resources,
        R.drawable.escuela
    )

    //Funcion de creacion propia como corrutina
    LaunchedEffect(Unit) {
        CreateChannelNotification(
            idChannel,
            context,
            name,
            descriptionText
        )
    }


    LazyColumn(modifier = modifier){
        items(favoriteCollectionsData2.chunked(2)){
                row->
            Row{

                row.forEach{ card->
                    Card(
                        modifier = Modifier
                            .weight(1f)
                            .padding(8.dp)
                    ) {
                        val isFavorite = remember { mutableStateOf(false) }

                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {

                            Image(
                                painter = painterResource(card.drawable),
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier.size(200.dp)
                            )
                            Row(
                                modifier = Modifier,
                                horizontalArrangement = Arrangement.Start
                            ) {
                                Text(
                                    stringResource(card.titulo),
                                    fontWeight = FontWeight.Bold)
                            }
                            Row(
                                modifier = Modifier,
                                horizontalArrangement = Arrangement.Start
                            ) {
                                Text(stringResource(card.descripcion))
                            }
                            Spacer(modifier = Modifier.height(5.dp))
                            Row(modifier = Modifier) {
                                IconButton(
                                    onClick = { isFavorite.value = !isFavorite.value },
                                    modifier = Modifier
                                        .clip(shape = CircleShape)
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Favorite,
                                        contentDescription = "Corazón",
                                        tint = if (isFavorite.value) Color.Red else Color.Unspecified
                                    )
                                }
                                IconButton(
                                    onClick = {
                                        notificacionImagen(
                                            context,
                                            idChannel,
                                            idNotification + 2,
                                            "Creart te da la bienvenida",
                                            textLong,
                                            imagenBig
                                        )
                                    },
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Person,
                                        contentDescription = "canvas"
                                    )
                                }
                            }
                            Row(modifier = Modifier) {
                                TextButton(
                                    onClick = {
                                        selectedProduct = card
                                    },
                                ) {
                                    Text(text = "Detalles")
                                }
                                ComprarButton()
                            }

                        }

                    }
                }
            }
        }
    }

    selectedProduct?.let { product ->
        Dialog(
            onDismissRequest = { selectedProduct = null },
            properties = DialogProperties(dismissOnBackPress = true, dismissOnClickOutside = true),
            content = {
                Box(
                    modifier = Modifier
                        .padding(16.dp)
                        .background(Color.White)
                        .clip(RoundedCornerShape(8.dp))
                ) {
                    Column(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth()
                    ) {
                        Image(
                            painter = painterResource(product.drawable),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(200.dp)
                                .align(Alignment.CenterHorizontally)
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = stringResource(product.titulo),
                            style = MaterialTheme.typography.h6,
                            modifier = Modifier.align(Alignment.CenterHorizontally)
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = stringResource(product.descripcion),
                            style = MaterialTheme.typography.body1,
                            modifier = Modifier.align(Alignment.CenterHorizontally)
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Row() {
                            TextButton(
                                onClick = { selectedProduct = null },
                            ) {
                                Text(text = "Cerrar")
                            }
                            TextButton(
                                onClick = {
                                    contadorState++
                                    selectedProduct = null
                                }
                            ) {
                                Text(text = "Comprar")
                            }
                        }
                    }
                }
            }
        )
    }

}


private val favoriteCollectionsData2 = listOf(

    Triple(R.drawable.canava42, canva, detallesc1),
    Triple(R.drawable.canav33, canva, detallesc2),
    Triple(R.drawable.canva3, canva, detallesc3),
    Triple(R.drawable.canva4, canva, detallesc4),
    Triple(R.drawable.canva10, canva, detallesc5),
    Triple(R.drawable.canva21, canva, detallesc6),
    Triple(R.drawable.canva23, canva, detallesc7),
    Triple(R.drawable.canva24, canva, detallesc8),
    Triple(R.drawable.canva25, canva, detallesc9),
    Triple(R.drawable.canva28, canva, detallesc10),
    Triple(R.drawable.canva44, canva, detallesc11),
    Triple(R.drawable.canava26, canva, detallesc12),
    Triple(R.drawable.canava65, canva, detallesc13),
    Triple(R.drawable.canva9, canva, detallesc14),
    Triple(R.drawable.canava31, canva, detallesc15),

    ).map {DrawableStringPairFlores2(it.first, it.second, it.third)}

private data class DrawableStringPairFlores2(
    @DrawableRes val drawable: Int,
    @StringRes val titulo: Int,
    @StringRes val descripcion: Int
)



package com.example.proyecto_dashboard.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyecto_dashboard.R

/*
 * Composable que muestra la página de contenido del usuario con su información personal y una foto de perfil.
 */
@Composable
fun Page_Contenidos() {
    // Composable principal que muestra la información del usuario y su foto de perfil
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(Modifier.fillMaxSize()) {
            // Foto de perfil del usuario
            Column(modifier = Modifier.shadow(elevation = 5.dp)
                .fillMaxWidth()){
                Text(
                    text = "Bienvenido",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(vertical = 16.dp)
                        .align(Alignment.CenterHorizontally)
                )
                Text(
                    text = "",
                    fontSize = 20.sp,
                    modifier = Modifier
                        .padding(vertical = 16.dp)
                        .align(Alignment.CenterHorizontally)
                )

            }
                Column(modifier = Modifier.shadow(elevation = 5.dp)
                ){
                    Text(
                        text = "Mis pedidos",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(vertical = 16.dp)
                            .align(Alignment.CenterHorizontally)
                    )
                    Spacer(modifier = Modifier.height(7.dp))
                    pedidos()
                }
            Column(modifier = Modifier.shadow(elevation = 5.dp)){
                Text(
                    text = "Pagos y descuentos",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(vertical = 16.dp)
                        .align(Alignment.CenterHorizontally)
                )
                Spacer(modifier = Modifier.height(7.dp))
                pagos()

            }
            Column(modifier = Modifier.shadow(elevation = 5.dp)){
                Text(
                    text = "Servicios",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(vertical = 16.dp)
                        .align(Alignment.CenterHorizontally)
                )
                Spacer(modifier = Modifier.height(7.dp))
                servicios()

            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}


@Composable
fun pedidos() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            PedidosButton("Pendientes", painterResource(R.drawable.ic_time))
            PedidosButton("Por enviar", painterResource(R.drawable.ic_box))
            PedidosButton("Enviados", painterResource(R.drawable.ic_box2))
            PedidosButton("Reseñas", painterResource(R.drawable.ic_resena))
        }
    }
}
@Composable
fun pagos() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            PedidosButton("Tarjetas", painterResource(R.drawable.ic_tarjeta))
            PedidosButton("Cupones", painterResource(R.drawable.ic_cupon))
            PedidosButton("Monedas", painterResource(R.drawable.ic_monedas))
        }
    }
}

@Composable
fun servicios() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            PedidosButton("Ayuda", painterResource(R.drawable.ic_help))
            PedidosButton("Sugerencias", painterResource(R.drawable.ic_sugerencias))
            PedidosButton("Preguntas", painterResource(R.drawable.ic_preguntas))
        }
    }
}


@Composable
fun PedidosButton(text: String, icon: Painter) {
    IconButton(
        onClick = { /* Acción de categoría */ },
        modifier = Modifier.padding(8.dp),
    ) {
        Column {
            Icon(
                painter = icon,
                contentDescription = null,
                modifier = Modifier
                    .size(24.dp)
                    .align(Alignment.CenterHorizontally),
                tint = Color(0xFF673AB7)
            )
            Text(text = text)
        }
    }
}


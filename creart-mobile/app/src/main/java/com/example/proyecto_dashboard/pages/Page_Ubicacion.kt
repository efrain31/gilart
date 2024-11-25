package com.example.proyecto_dashboard.pages

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.proyecto_dashboard.R
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.CameraPositionState
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerInfoWindow
import com.google.maps.android.compose.MarkerInfoWindowContent
import com.google.maps.android.compose.rememberCameraPositionState
import com.google.maps.android.compose.rememberMarkerState
import com.google.maps.android.compose.widgets.DisappearingScaleBar
import com.google.maps.android.compose.widgets.ScaleBar

//Puntos que se georeferencian
val senaCba = LatLng(20.65413848401732, -103.43186466088596)
val tiendaCba = LatLng(20.65413848401732, -103.43186466088596)
val unidadLacteosCba = LatLng(20.65413848401732, -103.43186466088596)
val unidadAgricolaCba = LatLng(20.65413848401732, -103.43186466088596)

@Composable
fun Page_Ubicacion() {
    Column() {
        MapasScreen()
    }
}

@Composable
fun MapasScreen() {
    val defaultCameraPosition = CameraPosition.fromLatLngZoom(senaCba, 15f)
    //objeto para pasar el mapa
    val cameraPositionState = rememberCameraPositionState{
        position = defaultCameraPosition
    }
    //variable para determinar si mapa se cargo
    var isMapLoaded by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 80.dp)
    ) {
        GoogleMapView(
            modifier = Modifier.matchParentSize(),
            cameraPositionState = cameraPositionState,
            onMapLoaded = {
                isMapLoaded = true
            }
        )
        if (!isMapLoaded) {
            AnimatedVisibility(
                modifier = Modifier
                    .matchParentSize(),
                visible = !isMapLoaded,
                enter = EnterTransition.None,
                exit = fadeOut()
            ) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .background(MaterialTheme.colors.background)
                        .wrapContentSize()
                )
            }
        }
    }
}

@Composable
fun GoogleMapView(
    modifier: Modifier,
    cameraPositionState: CameraPositionState = rememberCameraPositionState(),
    onMapLoaded: () -> Unit = {},
    content:  @Composable () -> Unit = {}
) {
    val context = LocalContext.current
    val senaCbaState = rememberMarkerState(position = senaCba)
    val tiendaCbaState = rememberMarkerState(position = tiendaCba)
    val unidadLacteosCbaState = rememberMarkerState(position = unidadLacteosCba)
    val unidadAgricolaCbaState = rememberMarkerState(position = unidadAgricolaCba)

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        GoogleMap(
            modifier = modifier,
            cameraPositionState = cameraPositionState,
            onMapLoaded = onMapLoaded
        ) {
            Marker(
                state = unidadAgricolaCbaState,
                title = "Cre-Art"
            )
            MarkerInfoWindowContent(
                state = unidadLacteosCbaState,
                icon = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)
            ){
                Text(
                    text = "Cre-Art",
                    color = Color.Black
                )
            }
            MarkerInfoWindow(
                state = tiendaCbaState,
                icon = BitmapDescriptorFactory.fromResource(R.drawable.creart)
            ) {
                Box(
                    modifier = Modifier.background(
                        color = MaterialTheme.colors.onPrimary,
                        shape = RoundedCornerShape(35.dp, 35.dp, 35.dp, 35.dp)
                    )
                        .height(230.dp)
                        .width(200.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.escuela),
                            contentDescription = null,
                            //contentScale = ContentScale.fit,
                        modifier = Modifier
                            .height(150.dp)
                            .fillMaxWidth()
                        )
                        Spacer(
                            modifier = Modifier
                            .height(24.dp)
                        )
                        Text(
                            text = "Cre-Art",
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .fillMaxWidth(),
                            style = MaterialTheme.typography.h3,
                            color = MaterialTheme.colors.primary
                        )
                    }
                }
            }
            content()
        }
        ScaleBar(
            modifier = Modifier
                .padding(top = 5.dp, end = 15.dp)
                .align(Alignment.TopEnd),
            cameraPositionState = cameraPositionState
        )
        DisappearingScaleBar(
            modifier = Modifier
                .padding(top = 5.dp, end = 15.dp)
                .align(Alignment.TopStart),
            cameraPositionState = cameraPositionState
        )
    }
}
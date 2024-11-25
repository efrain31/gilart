package com.example.proyecto_dashboard.components

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.proyecto_dashboard.ui.theme.Proyecto_DashboardTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Forum
import androidx.compose.material.icons.filled.ShoppingCart

@Composable
fun MainPage() {
    val navController = rememberNavController()
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    val context = LocalContext.current // Obtener el contexto para usar en el botón flotante

    // Opciones de navegación del drawer
    val navigationItems = listOf(
        MenuItem.Page01,
        MenuItem.Page02,
        MenuItem.Page03,
        MenuItem.Page04,
        MenuItem.Page05,
        MenuItem.Page06,
    )
    // Opciones de navegación del BottomBar
    val navigationItemsBottomBar = listOf(
        Items_Bar.Boton2,
        Items_Bar.Boton4,
    )

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopBar(
                scope,
                scaffoldState,
                navController,
                navigationItems
            )
        },
        drawerContent = {
            DrawerMenu(
                scope,
                scaffoldState,
                navController,
                menu_items = navigationItems
            )
        },
        bottomBar = {
            BottomMenu(
                navController,
                menu_items_bar = navigationItemsBottomBar
            )
        },
        floatingActionButton = {
            // FAB para abrir WhatsApp
            FloatingActionButton(
                onClick = {
                    // Intent para abrir WhatsApp
                    val intent = Intent(Intent.ACTION_VIEW).apply {
                        data = Uri.parse("https://wa.me/3327409328?text=¡Hola!%20Quiero%20información%20sobre%20tu%20producto.")
                    }
                    context.startActivity(intent) // Inicia la actividad con el intent
                }
            ) {
                Icon(Icons.Default.Forum, contentDescription = "Abrir WhatsApp")
            }
        }
    ) { padding ->
        ContentScaffold(padding)
        Navigation_Host(navController)
    }
}

@Composable
fun ContentScaffold(padding: PaddingValues) {
}

@Composable
fun CarritoSimulado() {
}

@Preview
@Composable
fun MainPagePreview() {
    Proyecto_DashboardTheme {
        MainPage()
    }
}

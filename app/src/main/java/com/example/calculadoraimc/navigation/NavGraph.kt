package com.example.calculadoraimc.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.calculadoraimc.screens.PantallaIngreso
import com.example.calculadoraimc.screens.PantallaResultado


@Composable
fun NavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "ingreso"
    ) {
        composable("ingreso") {
            PantallaIngreso(navController = navController)
        }

        // RETO 2: ruta con dos parámetros
        composable(
            route = "resultado/{nombre}/{imc}",
            arguments = listOf(
                navArgument("nombre") { type = NavType.StringType },
                navArgument("imc") { type = NavType.FloatType }
            )
        ) { backStackEntry ->
            val nombre = backStackEntry.arguments?.getString("nombre") ?: ""
            val imc = backStackEntry.arguments?.getFloat("imc") ?: 0f
            PantallaResultado(
                nombre = nombre,
                imc = imc.toDouble(),
                navController = navController
            )
        }
    }
}
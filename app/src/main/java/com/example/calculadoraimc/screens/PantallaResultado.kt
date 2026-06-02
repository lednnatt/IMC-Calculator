package com.example.calculadoraimc.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun PantallaResultado(
    nombre: String,
    imc: Double,
    navController: NavController
) {

    val (categoria, colorCategoria) = when {
        imc < 18.5 -> Pair("Bajo peso", Color.Red)
        imc < 25.0 -> Pair("Peso normal", Color(0xFF388E3C))   // verde
        imc < 30.0 -> Pair("Sobrepeso", Color(0xFFF57C00))      // naranja
        else       -> Pair("Obesidad", Color.Red)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Resultado",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(32.dp))


        Text(
            text = "Hola $nombre, tu resultado es:",
            fontSize = 18.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "IMC: ${"%.1f".format(imc)}",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(12.dp))

        // RETO 3: Categoría con color dinámico
        Text(
            text = categoria,
            fontSize = 22.sp,
            fontWeight = FontWeight.SemiBold,
            color = colorCategoria
        )

        Spacer(modifier = Modifier.height(40.dp))

        // Botón volver con popBackStack()
        OutlinedButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text(text = "Volver", fontSize = 16.sp)
        }
    }
}
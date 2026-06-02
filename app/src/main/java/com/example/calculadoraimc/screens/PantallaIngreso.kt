package com.example.calculadoraimc.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun PantallaIngreso(navController: NavController) {


    var nombre by remember { mutableStateOf("") }
    var peso by remember { mutableStateOf("") }
    var altura by remember { mutableStateOf("") }


    var mostrarError by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Calculadora de IMC",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(32.dp))


        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(16.dp))


        OutlinedTextField(
            value = peso,
            onValueChange = {
                peso = it
                mostrarError = false
            },
            label = { Text("Peso (kg)") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
        )

        Spacer(modifier = Modifier.height(16.dp))


        OutlinedTextField(
            value = altura,
            onValueChange = {
                altura = it
                mostrarError = false
            },
            label = { Text("Altura (m)") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
        )

        Spacer(modifier = Modifier.height(8.dp))


        if (mostrarError) {
            Text(
                text = "Por favor, ingresa valores válidos",
                color = Color.Red,
                fontSize = 14.sp
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                val pesoDouble = peso.toDoubleOrNull()
                val alturaDouble = altura.toDoubleOrNull()


                if (pesoDouble == null || pesoDouble <= 0.0 ||
                    alturaDouble == null || alturaDouble <= 0.0
                ) {
                    mostrarError = true
                } else {
                    mostrarError = false
                    val imc = pesoDouble / (alturaDouble * alturaDouble)

                    navController.navigate("resultado/$nombre/${imc.toFloat()}")
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text(text = "Calcular", fontSize = 16.sp)
        }
    }
}
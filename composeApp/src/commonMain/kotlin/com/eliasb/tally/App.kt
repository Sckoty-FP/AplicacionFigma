package com.eliasb.tally

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

enum class Pantalla { Login, Registro }

@Composable
fun App() {
    MaterialTheme {
        var pantalla by remember { mutableStateOf(Pantalla.Login) }

        when (pantalla) {
            Pantalla.Login -> LoginScreen(onIrRegistro = { pantalla = Pantalla.Registro })
            Pantalla.Registro -> RegistroScreen(onIrLogin = { pantalla = Pantalla.Login })
        }
    }
}

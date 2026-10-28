package com.eliasb.tally

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.eliasb.tally.recursos.Res
import com.eliasb.tally.recursos.tally_logo
import org.jetbrains.compose.resources.painterResource

@Composable
fun RegistroScreen(onIrLogin: () -> Unit) {
    var nombre by remember { mutableStateOf("") }
    var correo by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var repetirPassword by remember { mutableStateOf("") }
    var pais by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(FondoApp)
            .verticalScroll(rememberScrollState())
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        Spacer(Modifier.height(24.dp))
        Image(
            painter = painterResource(Res.drawable.tally_logo),
            contentDescription = "Logo de Tally",
            modifier = Modifier.height(80.dp)
        )
        Text("Complete los campos para registrarte", fontWeight = FontWeight.SemiBold)
        CampoTexto(nombre, { nombre = it }, "Nombres Y Apellidos", "Nombre Generico")
        CampoTexto(correo, { correo = it }, "Correo Electrónico", "ejemplo@correo.com")
        CampoTexto(password, { password = it }, "Contraseña", "••••••••••••", esPassword = true)
        CampoTexto(repetirPassword, { repetirPassword = it }, "Repetir Contraseña", "••••••••••••", esPassword = true)
        CampoTexto(pais, { pais = it }, "Pais", "Venezuela")
        BotonPrimario("Iniciar Sesion") { }
        EnlaceInferior("Ya posees una cuenta. Inicia sesión ", "Aquí", onIrLogin)
    }
}

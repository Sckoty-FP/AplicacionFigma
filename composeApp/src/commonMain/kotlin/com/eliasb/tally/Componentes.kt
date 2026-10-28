package com.eliasb.tally

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CampoTexto(
    valor: String,
    onCambio: (String) -> Unit,
    etiqueta: String,
    placeholder: String,
    esPassword: Boolean = false
) {
    var verPassword by remember { mutableStateOf(false) }

    OutlinedTextField(
        value = valor,
        onValueChange = onCambio,
        label = { Text(etiqueta) },
        placeholder = { Text(placeholder) },
        singleLine = true,
        shape = RoundedCornerShape(50),
        modifier = Modifier.fillMaxWidth(),
        visualTransformation = if (esPassword && !verPassword) PasswordVisualTransformation()
        else VisualTransformation.None,
        trailingIcon = if (esPassword) {
            {
                TextButton(onClick = { verPassword = !verPassword }) {
                    Text(if (verPassword) "Ocultar" else "Ver")
                }
            }
        } else null,
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedBorderColor = BordeCampo,
            focusedBorderColor = Verde,
            unfocusedContainerColor = Color.White,
            focusedContainerColor = Color.White
        )
    )
}

@Composable
fun BotonPrimario(texto: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth().height(52.dp),
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Verde)
    ) {
        Text(texto, fontSize = 18.sp)
    }
}

@Composable
fun BotonBorde(texto: String, onClick: () -> Unit, prefijo: String? = null) {
    OutlinedButton(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth().height(52.dp),
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.outlinedButtonColors(containerColor = Color.White)
    ) {
        if (prefijo != null) {
            Text(prefijo, fontWeight = FontWeight.Bold, color = TextoOscuro)
            Spacer(Modifier.width(8.dp))
        }
        Text(texto, fontSize = 18.sp, color = TextoOscuro)
    }
}

// texto con la ultima palabra en verde, se puede pulsar
@Composable
fun EnlaceInferior(prefijo: String, enlace: String, onClick: () -> Unit) {
    Text(
        text = buildAnnotatedString {
            append(prefijo)
            withStyle(SpanStyle(color = Verde, fontWeight = FontWeight.Bold)) {
                append(enlace)
            }
        },
        modifier = Modifier.clickable { onClick() },
        fontWeight = FontWeight.SemiBold,
        fontSize = 13.sp,
        textAlign = TextAlign.Center
    )
}

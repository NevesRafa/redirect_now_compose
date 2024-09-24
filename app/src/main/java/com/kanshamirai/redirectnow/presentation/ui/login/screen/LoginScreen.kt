package com.kanshamirai.redirectnow.presentation.ui.login.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kanshamirai.presentation.ui.theme.ExtendedTheme
import com.kanshamirai.redirectnow.R
import com.kanshamirai.redirectnow.presentation.composable.buttons.CustomButton


@Preview(showBackground = true)
@Composable
fun LoginScreen() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(ExtendedTheme.colors.white)
            .padding(ExtendedTheme.dimens.dimens4),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Redirect Now",
            style = ExtendedTheme.typography.bold24,
            color = ExtendedTheme.colors.darkBlue
        )
        Text(
            text = "facilitando a organização dos seus contatos",
            style = ExtendedTheme.typography.medium14,
            color = ExtendedTheme.colors.grayScale700
        )
        Spacer(modifier = Modifier.height(32.dp))

        // Botão "Continuar com Google"
        Button(
            onClick = { /* TODO: Implementar login com Google */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(ExtendedTheme.dimens.dimens13),
            shape = RoundedCornerShape(ExtendedTheme.dimens.dimens6),
            border = BorderStroke(width = 1.dp, color = ExtendedTheme.colors.darkBlue),
            colors = ButtonDefaults.buttonColors(ExtendedTheme.colors.white) // Branco
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_google),
                contentDescription = "Google Logo",
                modifier = Modifier.size(ButtonDefaults.IconSize)
            )
            Spacer(Modifier.size(ButtonDefaults.IconSpacing))
            Text(
                text = "Continue com Google",
                style = ExtendedTheme.typography.semiBold16,
                color = ExtendedTheme.colors.darkBlue
            )
        }
        Spacer(
            modifier = Modifier
                .height(ExtendedTheme.dimens.dimens6)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Divider(
                modifier = Modifier
                    .weight(1f),
                color = ExtendedTheme.colors.lightGray
            )
            Text(
                text = "  Ou continue com  ",
                style = ExtendedTheme.typography.semiBold14,
                color = ExtendedTheme.colors.grayScale700
            )
            Divider(
                modifier = Modifier
                    .weight(1f),
                color = ExtendedTheme.colors.lightGray
            )
        }
        Spacer(
            modifier = Modifier
                .height(ExtendedTheme.dimens.dimens4)
        )

        // Campos de email e senha
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Senha") },
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Botão "Continuar com Email"
        CustomButton(
            onButtonClick = { /* TODO: Implementar login com email */ },
            text = "Continue com Email"
        )

        Spacer(
            modifier = Modifier
                .height(ExtendedTheme.dimens.dimens4)
        )

        // Texto "Não tem uma conta? Cadastra-se" e "Entrar sem login"
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Não tem uma conta? ",
                style = ExtendedTheme.typography.medium14,
                color = ExtendedTheme.colors.grayScale700
            )
            Text(
                text = "Cadastra-se",
                style = ExtendedTheme.typography.semiBold14,
                color = ExtendedTheme.colors.darkBlue
            )
        }
        Spacer(
            modifier = Modifier
                .height(ExtendedTheme.dimens.dimens2)
        )

        Text(
            text = "Entrar sem login",
           style = ExtendedTheme.typography.semiBold14,
            color = ExtendedTheme.colors.darkBlue
        )
    }
}

@Preview
@Composable
fun PreviewLoginScreen() {
    LoginScreen()
}


package com.kanshamirai.redirectnow.presentation.composable.buttons

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.kanshamirai.presentation.ui.theme.ExtendedTheme

@Composable
fun Button(
    modifier: Modifier = Modifier,
    isEnabled: Boolean = true,
    startIcon: Int? = null,
    endIcon: Int? = null,
    text: String,
    onButtonClick: () -> Unit = {}
) {

    Button(modifier = modifier
        .wrapContentHeight(),
        shape = RoundedCornerShape(corner = CornerSize(ExtendedTheme.dimens.dimens13)),
        enabled = isEnabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = ExtendedTheme.colors.darkBlue,
            contentColor = ExtendedTheme.colors.white,
            disabledContainerColor = ExtendedTheme.colors.lightBlue,
            disabledContentColor = ExtendedTheme.colors.white
        ),
        onClick = { onButtonClick() }) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = ExtendedTheme.dimens.dimens2),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
        ) {
            startIcon?.let {
                Image(
                    modifier = Modifier
                        .size(ExtendedTheme.dimens.dimens6),
                    painter = painterResource(id = it),
                    contentDescription = "",
                    contentScale = ContentScale.Fit
                )
            }
            Spacer(Modifier.weight(1f))
            Text(
                modifier = Modifier
                    .padding(horizontal = ExtendedTheme.dimens.dimens3),
                text = text,
                textAlign = TextAlign.Center,
                style = ExtendedTheme.typography.semiBold16
            )
            Spacer(Modifier.weight(1f))
            endIcon?.let {
                Image(
                    modifier = Modifier
                        .size(ExtendedTheme.dimens.dimens6),
                    painter = painterResource(id = it),
                    contentDescription = "",
                    contentScale = ContentScale.Fit
                )
            }
        }
    }
}

@Preview(name = "Botão padrão")
@Composable
fun PreviewButton() {
    ExtendedTheme {
        Button(
            modifier = Modifier.fillMaxWidth(),
            text = "Label",
            isEnabled = true,
            onButtonClick = {},
            endIcon = null,
            startIcon = null,
        )
    }
}


@Preview(name = "Botão desabilitado")
@Composable
fun PreviewButton2() {
    ExtendedTheme {
        Button(
            modifier = Modifier.fillMaxWidth(),
            text = "Label",
            isEnabled = false,
            onButtonClick = {},
            endIcon = null,
            startIcon = null,
        )
    }
}
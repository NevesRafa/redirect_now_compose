package com.kanshamirai.redirectnow.presentation.composable.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.kanshamirai.presentation.ui.theme.ExtendedTheme
import com.kanshamirai.redirectnow.R

@Composable
fun InfoItem(
    icon: Int,
    title: String,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(ExtendedTheme.dimens.dimens4)
            .background(ExtendedTheme.colors.white)
            .clickable { onClick() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = "",
            tint = ExtendedTheme.colors.darkBlue,
            modifier = Modifier
                .padding(start = ExtendedTheme.dimens.dimens4)
                .size(ExtendedTheme.dimens.dimens6)
        )

        Spacer(modifier = Modifier.width(ExtendedTheme.dimens.dimens4))

        Text(
            text = title,
            style = ExtendedTheme.typography.semiBold16,
            color = ExtendedTheme.colors.darkBlue,
        )

        Spacer(modifier = Modifier.weight(1f))

        Icon(
            painter = painterResource(id = R.drawable.ic_arrow_right),
            contentDescription = "Arrow Icon",
            tint = ExtendedTheme.colors.darkBlue,
            modifier = Modifier
                .padding(end = ExtendedTheme.dimens.dimens4)
                .size(ExtendedTheme.dimens.dimens6)
        )
    }
}

@Preview(showBackground = true, name = "Personal Info Item")
@Composable
fun PreviewPersonalInfoItem() {
    InfoItem(
        icon = R.drawable.ic_person,
        title = " Informações Pessoais",
        onClick = {}
    )
}

@Preview(showBackground = true, name = "Password Info Item")
@Composable
fun PreviewPasswordInfoItem() {
    InfoItem(
        icon = R.drawable.ic_password,
        title = " Alterar Senha",
        onClick = {}
    )
}

@Preview(showBackground = true, name = "Language Info Item")
@Composable
fun PreviewLanguageInfoItem() {
    InfoItem(
        icon = R.drawable.ic_language,
        title = " Idioma",
        onClick = {}
    )
}

@Preview(showBackground = true, name = "Legal and Policies Info Item")
@Composable
fun PreviewLegalAndPoliciesInfoItem() {
    InfoItem(
        icon = R.drawable.ic_shield,
        title = " Termos e Políticas",
        onClick = {}
    )
}

@Preview(showBackground = true, name = "Help Info Item")
@Composable
fun PreviewHelpInfoItem() {
    InfoItem(
        icon = R.drawable.ic_question,
        title = " Ajuda",
        onClick = {}
    )
}

@Preview(showBackground = true, name = "About Info Item")
@Composable
fun PreviewAboutInfoItem() {
    InfoItem(
        icon = R.drawable.ic_about,
        title = " Sobre",
        onClick = {}
    )
}

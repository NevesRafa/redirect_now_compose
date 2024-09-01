package com.kanshamirai.redirectnow.presentation.composable.cards

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kanshamirai.presentation.ui.theme.ExtendedTheme
import com.kanshamirai.redirectnow.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomCard(
    cardTitle: String,
    cardSubtitle: String? = null,
    cardIcon: Int,
    onClickIcon: () -> Unit,
    onClickCard: () -> Unit,
) {
    Card(
        modifier = Modifier
            .padding(ExtendedTheme.dimens.dimens2)
            .fillMaxWidth(),
        shape = RoundedCornerShape(ExtendedTheme.dimens.dimens4),
        onClick = { onClickCard() },
        border = BorderStroke(1.dp, ExtendedTheme.colors.lightGray),
    ) {
        Row(
            modifier = Modifier
                .background(ExtendedTheme.colors.white)
                .fillMaxWidth()
                .padding(ExtendedTheme.dimens.dimens4),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = { onClickIcon() },
                modifier = Modifier
                    .size(ExtendedTheme.dimens.dimens12)
                    .background(
                        ExtendedTheme.colors.lightGray,
                        RoundedCornerShape(ExtendedTheme.dimens.dimens3)
                    )
            ) {
                Icon(
                    painter = painterResource(id = cardIcon),
                    contentDescription = "Heart Icon",
                    tint = ExtendedTheme.colors.darkBlue
                )
            }

            Spacer(modifier = Modifier.width(ExtendedTheme.dimens.dimens4))

            Column {
                Text(
                    text = cardTitle,
                    style = ExtendedTheme.typography.bold16,
                    color = ExtendedTheme.colors.darkBlue
                )

                cardSubtitle?.let {
                    Text(
                        text = it,
                        style = ExtendedTheme.typography.semiBold12,
                        color = ExtendedTheme.colors.grayScale700
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, name = "Card with subtitle")
@Composable
fun CardItemPreview() {
    CustomCard(
        cardTitle = "Amigos",
        cardSubtitle = "Faculdade e Trabalho",
        cardIcon = R.drawable.ic_heart,
        onClickIcon = { },
        onClickCard = { }
    )
}

@Preview(showBackground = true, name = "Card without subtitle")
@Composable
fun CardItemWithoutSubtitlePreview() {
    CustomCard(
        cardTitle = "Restaurantes",
        cardIcon = R.drawable.ic_fast_food,
        onClickIcon = { },
        onClickCard = { }
    )
}

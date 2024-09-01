package com.kanshamirai.redirectnow.presentation.composable.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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

@Composable
fun ContactCard(
    contactName: String,
    contactPhone: String,
    isFavorite: Boolean,
    onCallClick: () -> Unit,
    onMessageClick: () -> Unit,
    onFavoriteClick: () -> Unit,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(ExtendedTheme.dimens.dimens2),
        shape = RoundedCornerShape(ExtendedTheme.dimens.dimens4),
        elevation = CardDefaults.cardElevation(ExtendedTheme.dimens.dimens1)
    ) {
        Row(
            modifier = Modifier
                .background(ExtendedTheme.colors.white)
                .fillMaxWidth()
                .padding(ExtendedTheme.dimens.dimens4),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = { onFavoriteClick() },
                modifier = Modifier.size(40.dp)
            ) {
                isFavorite?.let {
                    if (!it) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_star_outline),
                            contentDescription = "Favorite Icon",
                            tint = ExtendedTheme.colors.darkBlue
                        )
                    } else {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_star),
                            contentDescription = "Favorite Icon",
                            tint = ExtendedTheme.colors.yellow
                        )
                    }

                }
            }

            Spacer(modifier = Modifier.width(ExtendedTheme.dimens.dimens4))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = contactName,
                    style = ExtendedTheme.typography.bold16,
                    color = ExtendedTheme.colors.darkBlue
                )
                Text(
                    text = contactPhone,
                    style = ExtendedTheme.typography.semiBold12,
                    color = ExtendedTheme.colors.grayScale700,
                )
            }

            Row(
                horizontalArrangement = Arrangement.spacedBy(ExtendedTheme.dimens.dimens4),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = { onCallClick() }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_phone),
                        contentDescription = "Phone Icon",
                        tint = ExtendedTheme.colors.darkBlue
                    )
                }
                IconButton(
                    onClick = { onMessageClick() }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_message),
                        contentDescription = "Message Icon",
                        tint = ExtendedTheme.colors.darkBlue
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, name = "Contact Card")
@Composable
fun PreviewContactCard() {
    ContactCard(
        contactName = "Kansha Mirai",
        contactPhone = "+55 11 99999-9999",
        isFavorite = false,
        onCallClick = { },
        onMessageClick = { },
        onFavoriteClick = { }
    )
}

@Preview(showBackground = true, name = "Contact Card Favorite")
@Composable
fun PreviewContactCardFavorite() {
    ContactCard(
        contactName = "Kansha Mirai",
        contactPhone = "+55 11 99999-9999",
        isFavorite = true,
        onCallClick = { },
        onMessageClick = { },
        onFavoriteClick = { }
    )
}
package dev.vincenzocostagliola.designsystem.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import dev.vincenzocostagliola.designsystem.R
import dev.vincenzocostagliola.designsystem.theme.Dark

@Composable
fun NavigationListItem(textToShow: String, description: String, goTo: (String) -> Unit) {
        Surface(
            onClick = { goTo(description) }
        ) {
            Column {
                ListItem(
                    headlineContent = { textToShow },
                    trailingContent = {
                        IconButton(
                            onClick = {}
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.chevron_right),
                                contentDescription = "",
                                tint = Dark
                            )
                        }
                    }
                )
                HorizontalDivider()
            }
        }
    }

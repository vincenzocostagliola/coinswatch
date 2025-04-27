package dev.vincenzocostagliola.coindetails.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import dev.vincenzocostagliola.coindetails.R
import dev.vincenzocostagliola.designsystem.composables.TopBar
import dev.vincenzocostagliola.designsystem.theme.ExtraLight
import dev.vincenzocostagliola.designsystem.values.Dimens

@Composable
fun DescriptionScreen(
    description: String,
    onBackPressed: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier
            .background(ExtraLight),
        topBar = {
            TopBar(
                title = stringResource(R.string.description),
                onBackButton = onBackPressed
            )
        }
    ) {
        Column(
            modifier = modifier
                .padding(it)
                .fillMaxSize()
                .padding(Dimens.XRegular)
                .verticalScroll(rememberScrollState())
        ) {
            Text(description)
        }
    }
}
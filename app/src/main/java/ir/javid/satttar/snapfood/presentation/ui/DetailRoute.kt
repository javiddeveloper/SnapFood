package ir.javid.satttar.snapfood.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import ir.javid.satttar.snapfood.R
import ir.javid.satttar.snapfood.presentation.viewModel.MainScreenStates
import ir.javid.satttar.snapfood.presentation.viewModel.MainViewModel

/**
 * @author  : Javid
 * @summary : DetailRoute
 */

@Composable
fun DetailRoute(
    videoId: Int,
    viewModel: MainViewModel
) {
    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.getAllVideos()
    }


    DetailScreen(
        uiState = uiState,
    )
}

@Composable
private fun DetailScreen(
    uiState: MainScreenStates
) {
    Scaffold(
        topBar = {

        },
    ) { padding ->
        if (uiState.iisLoading) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        } else if (uiState.video == null) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(id = R.string.empty_message),
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        } else {
            Text(uiState.video.toString())
        }
    }
}

package ir.javid.satttar.snapfood.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ir.javid.satttar.snapfood.presentation.viewModel.MainViewModel
import ir.javid.satttar.snapfood.presentation.viewModel.StarWarsData
import ir.javid.satttar.snapfood.presentation.viewModel.StarWarsIntent
import ir.javid.satttar.snapfood.presentation.viewModel.StarWarsState
import ir.javid.satttar.snapfood.presentation.viewModel.StarWarsState.Empty
import ir.javid.satttar.snapfood.presentation.viewModel.StarWarsState.Loading

/**
 * @author  : Javid
 * @summary : DetailRoute
 */

@Composable
fun DetailRoute(
    characterId: String,
    viewModel: MainViewModel
) {
    val uiState by viewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.onIntent(StarWarsIntent.GetCharacterDetails(characterId))
    }

    DetailScreen(
        uiState = uiState.state,
        uiData = uiState.data,
    )
}

@Composable
private fun DetailScreen(
    uiState: StarWarsState,
    uiData: StarWarsData?,
) {
    Scaffold(
        topBar = {
        },
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            when (uiState) {
                is Loading -> CircularProgressIndicator()
                is Empty -> Text("No results found.")
                is StarWarsState.CharacterDetailsLoaded -> {
                    val characterWithDetails = uiData?.character
                    characterWithDetails?.let {
                        Column(modifier = Modifier.padding(16.dp)) {

                            Text(
                                text = characterWithDetails.character.properties.name,
                                style = MaterialTheme.typography.titleLarge,
                                color = MaterialTheme.colorScheme.primary,
                                modifier = Modifier.padding(bottom = 8.dp)
                            )

                            DetailRow(label = "Height", value = characterWithDetails.character.properties.height)
                            DetailRow(label = "Mass", value = characterWithDetails.character.properties.mass)
                            DetailRow(label = "Hair Color", value = characterWithDetails.character.properties.hairColor)
                            DetailRow(label = "Skin Color", value = characterWithDetails.character.properties.skinColor)
                            DetailRow(label = "Eye Color", value = characterWithDetails.character.properties.eyeColor)
                            DetailRow(label = "Birth Year", value = characterWithDetails.character.properties.birthYear)
                            DetailRow(label = "Gender", value = characterWithDetails.character.properties.gender)
                            DetailRow(label = "Homeworld", value = characterWithDetails.character.properties.homeworld)

                            Spacer(modifier = Modifier.height(16.dp))

                            Text(
                                text = "Video Details",
                                style = MaterialTheme.typography.titleLarge,
                                color = MaterialTheme.colorScheme.primary,
                                modifier = Modifier.padding(bottom = 8.dp)
                            )

                            DetailRow(label = "Video Description", value = characterWithDetails.videoDetails?.description)
                            DetailRow(label = "Video UID", value = characterWithDetails.videoDetails?.uid)
                            DetailRow(label = "Video Created", value = characterWithDetails.videoDetails?.properties?.created)
                            DetailRow(label = "Video Edited", value = characterWithDetails.videoDetails?.properties?.edited)
                            DetailRow(label = "Video Name", value = characterWithDetails.videoDetails?.properties?.name)
                            DetailRow(label = "Video Climate", value = characterWithDetails.videoDetails?.properties?.climate)
                        }
                    }
                }

                else -> {}
            }
        }
    }
}

@Composable
fun DetailRow(label: String, value: String?) {
    if (value == null) return
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = value,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.secondary
        )
    }
}
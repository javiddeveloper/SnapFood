package ir.javid.satttar.snapfood.presentation.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ir.javid.satttar.snapfood.domain.model.CharacterVideo
import ir.javid.satttar.snapfood.presentation.viewModel.MainViewModel
import ir.javid.satttar.snapfood.presentation.viewModel.StarWarsData
import ir.javid.satttar.snapfood.presentation.viewModel.StarWarsIntent
import ir.javid.satttar.snapfood.presentation.viewModel.StarWarsState
import ir.javid.satttar.snapfood.presentation.viewModel.StarWarsState.CharactersLoaded
import ir.javid.satttar.snapfood.presentation.viewModel.StarWarsState.Empty
import ir.javid.satttar.snapfood.presentation.viewModel.StarWarsState.Error
import ir.javid.satttar.snapfood.presentation.viewModel.StarWarsState.Loading

/**
 * @author  : Javid
 * @summary : MainRoute
 */
const val MAX_QUERY_LENGTH = 1
@Composable
fun MainRoute(
    viewModel: MainViewModel,
    onCharacterSelected: (String) -> Unit
) {
    val uiState by viewModel.state.collectAsState()

    var searchValue by remember {
        mutableStateOf("")
    }

    LaunchedEffect(searchValue) {
        if (searchValue.isNotBlank() && searchValue.length >= MAX_QUERY_LENGTH)
            viewModel.onIntent(StarWarsIntent.SearchCharacters(searchValue))

    }
    LaunchedEffect(Unit) {
        viewModel.updateState(newState= CharactersLoaded)
    }

    MainScreen(
        uiState = uiState.state,
        uiData = uiState.data,
        searchValue = searchValue,
        onCharacterSelected = {
            onCharacterSelected(it.uid)
        },
        searchCharacters = { query ->
            searchValue = query
        }
    )
}

@Composable
private fun MainScreen(
    uiState: StarWarsState,
    uiData: StarWarsData?,
    searchValue: String,
    searchCharacters: (String) -> Unit,
    onCharacterSelected: (CharacterVideo) -> Unit,
) {
    Scaffold(
        topBar = {
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            verticalArrangement = Arrangement.Top
        ) {
            TextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = searchValue,
                onValueChange = { query ->
                    searchCharacters(query)
                },
                label = { Text("Search Characters") }
            )
            when (uiState) {
                is Loading -> CircularProgressIndicator()
                is Empty -> Text("No results found.")
                is CharactersLoaded -> {
                    val characters = uiData?.characters
                    characters?.let {
                        LazyColumn {
                            items(characters.size, key = { characters[it].id }) { index ->
                                CharacterItem(characters[index]){
                                    onCharacterSelected(it)
                                }
                            }
                        }
                    }
                }

                is Error -> Text(
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxSize(),
                    text = "Error: ${uiState.message}"
                )

                else -> {}
            }
        }
    }
}
@Composable
fun CharacterItem(
    character: CharacterVideo,
    onClick:(CharacterVideo)->Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable {
                onClick(character)
            },
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // Name
            Text(
                text = character.properties.name,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.primary
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Basic Info Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Height: ${character.properties.height} cm",
                    style = MaterialTheme.typography.labelLarge
                )
                Text(
                    text = "Mass: ${character.properties.mass} kg",
                    style = MaterialTheme.typography.labelLarge
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Other Properties
            Text(
                text = "Hair Color: ${character.properties.hairColor}",
                style = MaterialTheme.typography.labelLarge
            )
            Text(
                text = "Eye Color: ${character.properties.eyeColor}",
                style = MaterialTheme.typography.labelLarge
            )
            Text(
                text = "Birth Year: ${character.properties.birthYear}",
                style = MaterialTheme.typography.labelLarge
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Description
            Text(
                text = character.description,
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.secondary
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewItem() {
    MainScreen(
        uiState = Error("Error"),
        uiData = StarWarsData(),
        searchValue = "",
        searchCharacters = {},
        onCharacterSelected = {},
    )
}


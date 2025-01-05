package ir.javid.satttar.snapfood.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.javid.satttar.snapfood.domain.useCase.ManageVideosUseCase
import ir.javid.satttar.snapfood.presentation.tools.ViewState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @author  : Javid
 * @summary : MainViewModel
 */

@HiltViewModel
class MainViewModel @Inject constructor(
    private val useCase: ManageVideosUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(ViewState<StarWarsData>(StarWarsState.Idle))
    val state = _state.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), _state.value)

    // Handle user intents
    fun onIntent(intent: StarWarsIntent) {
        viewModelScope.launch {
            when (intent) {
                is StarWarsIntent.SearchCharacters -> searchCharacters(intent.query)
                is StarWarsIntent.GetCharacterDetails -> getCharacterDetails(intent.characterId)
            }
        }
    }

    fun updateState(newState: StarWarsState, data: StarWarsData? = null) {
        _state.update {
            it.copy(state = newState, data = data)
        }
    }

    private fun searchCharacters(query: String) = viewModelScope.launch {
        _state.update { it.copy(state = StarWarsState.Loading) }
        useCase.searchCharacters(query).collect { result ->
            if (result.isEmpty())
                _state.update { it.copy(state = StarWarsState.Empty) }
            else
                _state.update {
                    it.copy(
                        state = StarWarsState.CharactersLoaded,
                        data = StarWarsData(
                            characters = result
                        )
                    )
                }
        }

    }


    private fun getCharacterDetails(characterId: String) = viewModelScope.launch {
        _state.update { it.copy(state = StarWarsState.Loading) }
        useCase.getCharacterDetails(characterId).collect { result ->
            _state.update {
                it.copy(
                    state = StarWarsState.CharacterDetailsLoaded,
                    data = StarWarsData(
                        character = result
                    )
                )
            }
        }
    }
}






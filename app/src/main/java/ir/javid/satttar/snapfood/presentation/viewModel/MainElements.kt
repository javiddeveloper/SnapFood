package ir.javid.satttar.snapfood.presentation.viewModel

import ir.javid.satttar.snapfood.domain.model.CharacterVideo
import ir.javid.satttar.snapfood.domain.model.CharacterWithDetails

/**
 * @author  : Javid
 * @summary : MainElements
 */

sealed class StarWarsIntent {
    data class SearchCharacters(val query: String) : StarWarsIntent()
    data class GetCharacterDetails(val characterId: String) : StarWarsIntent()
}
sealed class StarWarsState {
    data object Idle : StarWarsState()
    data object Loading : StarWarsState()
    data object CharacterDetailsLoaded : StarWarsState()
    data object CharactersLoaded : StarWarsState()
    data object Empty : StarWarsState()
    data class Error(val message: String) : StarWarsState()
}

data class StarWarsData(
    val characters: List<CharacterVideo>?=null,
    val character: CharacterWithDetails?=null,
)


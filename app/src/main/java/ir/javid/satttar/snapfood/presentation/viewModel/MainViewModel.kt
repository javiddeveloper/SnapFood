package ir.javid.satttar.snapfood.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.javid.satttar.snapfood.domain.model.Video
import ir.javid.satttar.snapfood.domain.useCase.ManageVideosUseCase
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

    private val _uiState = MutableStateFlow(MainScreenStates())
    val uiState =
        _uiState.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), _uiState.value)


    fun getAllVideos() {
        viewModelScope.launch {
            _uiState.update {
                it.copy(iisLoading = true)
            }
            val response = useCase.getAllVideos()
            _uiState.update {
                it.copy(
                    iisLoading = false,
                    videos = response
                )
            }
        }
    }
    fun getVideo(id:Int) {
        viewModelScope.launch {
            _uiState.update {
                it.copy(iisLoading = true)
            }
            val response = useCase.detailVideo(id)
            _uiState.update {
                it.copy(
                    iisLoading = false,
                    video = response
                )
            }
        }
    }
}


data class MainScreenStates(
    val iisLoading: Boolean = false,
    val videos: List<Video>? = null,
    val video: Video? = null
)

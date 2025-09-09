package com.example.gallery_art.ui.theme

import androidx.compose.animation.core.updateTransition
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.gallery_art.data.dataList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class GalleryArtViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(GalleryArtUiState())
    val uiState: StateFlow<GalleryArtUiState> = _uiState.asStateFlow()

    fun showNextArt() {
        var nextIndex = _uiState.value.index + 1
        if (nextIndex < 5) {
            updateArtWall(nextIndex)
        } else {
            val newIndex = 4
            updateArtWall(newIndex)
        }

    }
    fun showPreviousArt(){
        var previousIndex = _uiState.value.index - 1
        val currentIndex = _uiState.value.index

        if (currentIndex > 0) {
            updateArtWall(previousIndex)
        }
        else if (currentIndex == 0){
            val newIndex = 0
            updateArtWall(newIndex)
        }
    }
    private fun updateArtWall(nextIndex: Int) {
        _uiState.update { currentState ->
            currentState.copy(
                index = nextIndex,
                imageArt = dataList[nextIndex].imageArt,
                artLocation = dataList[nextIndex].location,
                artAuthor = dataList[nextIndex].author
            )

        }
    }
}



internal val GalleryAppViewModel = GalleryArtViewModel()
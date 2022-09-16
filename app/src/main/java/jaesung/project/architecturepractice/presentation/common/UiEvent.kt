package jaesung.project.architecturepractice.presentation.common

sealed class UiEvent {
    data class ShowToast(val message: String) : UiEvent()
}

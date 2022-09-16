package jaesung.project.architecturepractice.presentation.test1

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import jaesung.project.architecturepractice.data.network.model.NetworkResult
import jaesung.project.architecturepractice.domain.model.PlaceData
import jaesung.project.architecturepractice.domain.usecase.GetPlaceListUseCase
import jaesung.project.architecturepractice.presentation.common.UiEvent
import jaesung.project.architecturepractice.presentation.common.UiState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import timber.log.Timber

class Test1ViewModel(
    private val getPlaceListUseCase: GetPlaceListUseCase
) : ViewModel() {

    private val _placeFlow = MutableStateFlow<UiState<PlaceData>>(UiState.Loading)
    val placeFlow: StateFlow<UiState<PlaceData>> = _placeFlow.asStateFlow()

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow: SharedFlow<UiEvent> = _eventFlow.asSharedFlow()


    fun getPlaceList() {
        viewModelScope.launch {
            val response = getPlaceListUseCase.invoke()

            response.collect { networkResult ->
                when (networkResult) {
                    is NetworkResult.Success -> {
                        if (networkResult.code == 200) {
                            Timber.e("Success 200 + $networkResult")
                            delay(2000L)
                            _placeFlow.value = UiState.Success(networkResult.data)
                        } else if (networkResult.code == 400) {
                            Timber.e("Success 400 + $networkResult")
                        }
                    }
                    is NetworkResult.Error -> {
                        Timber.e("Error + $networkResult")
                        _eventFlow.emit(UiEvent.ShowToast(networkResult.message))
                    }
                    is NetworkResult.Exception -> {
                        Timber.e("Exception + $networkResult")
                    }
                }
            }
        }
    }



}
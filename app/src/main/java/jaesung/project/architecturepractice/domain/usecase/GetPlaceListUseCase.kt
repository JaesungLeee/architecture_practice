package jaesung.project.architecturepractice.domain.usecase

import jaesung.project.architecturepractice.domain.repository.PlaceRepository

class GetPlaceListUseCase(private val placeRepository: PlaceRepository) {

    operator fun invoke() = placeRepository.getPlace()
}
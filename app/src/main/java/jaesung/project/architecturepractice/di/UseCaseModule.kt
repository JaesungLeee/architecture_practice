package jaesung.project.architecturepractice.di

import jaesung.project.architecturepractice.domain.usecase.GetPlaceListUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single<GetPlaceListUseCase> { GetPlaceListUseCase(get()) }
}
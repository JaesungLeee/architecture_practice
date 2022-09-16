package jaesung.project.architecturepractice.di

import jaesung.project.architecturepractice.data.repository.PlaceRepositoryImpl
import jaesung.project.architecturepractice.domain.repository.PlaceRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<PlaceRepository> { PlaceRepositoryImpl(get()) }
}
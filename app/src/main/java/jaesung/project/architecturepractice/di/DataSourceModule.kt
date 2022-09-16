package jaesung.project.architecturepractice.di

import jaesung.project.architecturepractice.data.datasource.remote.PlaceRemoteDataSourceImpl
import jaesung.project.architecturepractice.data.datasource.source.PlaceDataSource
import org.koin.dsl.module

val dataSourceModule = module {
    single<PlaceDataSource> { PlaceRemoteDataSourceImpl(get()) }
}
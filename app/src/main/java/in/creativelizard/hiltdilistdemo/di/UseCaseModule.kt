package `in`.creativelizard.hiltdilistdemo.di

import `in`.creativelizard.hiltdilistdemo.repos.DataRepository
import `in`.creativelizard.hiltdilistdemo.usecase.DataUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
object UseCaseModule {

    @Provides
    fun providesDataUseCase(dataRepository: DataRepository): DataUseCase {
        return DataUseCase(dataRepository)
    }
}
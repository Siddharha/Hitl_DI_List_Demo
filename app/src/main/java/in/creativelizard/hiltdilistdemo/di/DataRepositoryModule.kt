package `in`.creativelizard.hiltdilistdemo.di

import `in`.creativelizard.hiltdilistdemo.network.ApiService
import `in`.creativelizard.hiltdilistdemo.repos.DataRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
object DataRepositoryModule {
    @Provides
    fun provideDataRepository(apiService: ApiService): DataRepository {
        return DataRepository(apiService)
    }
}
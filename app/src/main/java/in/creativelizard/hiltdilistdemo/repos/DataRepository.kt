package `in`.creativelizard.hiltdilistdemo.repos

import `in`.creativelizard.hiltdilistdemo.models.RepositoriesModel
import `in`.creativelizard.hiltdilistdemo.network.ApiService
import javax.inject.Inject

class DataRepository @Inject constructor(private val apiService: ApiService){

    suspend fun getRepoList(since:String): RepositoriesModel {
        return apiService.getPublicRepositories(since)
    }
}
package `in`.creativelizard.hiltdilistdemo.usecase

import `in`.creativelizard.hiltdilistdemo.models.RepositoriesModel
import `in`.creativelizard.hiltdilistdemo.network.ResultData
import `in`.creativelizard.hiltdilistdemo.repos.DataRepository
import javax.inject.Inject

class DataUseCase @Inject constructor(private val dataRepository: DataRepository) {

    suspend fun getRepositoriesList(since: String): ResultData<RepositoriesModel> {
        val repositoriesModel = dataRepository.getRepoList(since = since)

        val resultData = when(repositoriesModel.isNotEmpty()) {
            true -> {
                ResultData.Success(repositoriesModel)
            }
            else -> {
                ResultData.Failed()
            }
        }
        return resultData
    }

}
package `in`.creativelizard.hiltdilistdemo.ui.viewmodel

import `in`.creativelizard.hiltdilistdemo.models.RepositoriesModel
import `in`.creativelizard.hiltdilistdemo.network.ResultData
import `in`.creativelizard.hiltdilistdemo.usecase.DataUseCase
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow

class MainViewModel@ViewModelInject constructor(
    private val dataUseCase: DataUseCase,
) : ViewModel() {
    fun getRepoList(since:String):LiveData<ResultData<RepositoriesModel?>>{
        return flow {
            emit(ResultData.Loading())
            try {
                emit(dataUseCase.getRepositoriesList(since = since))
            } catch (e: Exception) {
                e.printStackTrace()
                emit(ResultData.Exception())
            }
        }.asLiveData(Dispatchers.IO)
    }
}
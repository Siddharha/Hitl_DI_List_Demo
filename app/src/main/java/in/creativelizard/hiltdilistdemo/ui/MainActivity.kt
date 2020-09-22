package `in`.creativelizard.hiltdilistdemo.ui
import `in`.creativelizard.hiltdilistdemo.R
import `in`.creativelizard.hiltdilistdemo.models.RepositoriesModel
import `in`.creativelizard.hiltdilistdemo.network.ResultData
import `in`.creativelizard.hiltdilistdemo.ui.adapters.MainListAdapter
import `in`.creativelizard.hiltdilistdemo.ui.viewmodel.MainViewModel
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var mainAdapter: MainListAdapter
    private val mainViewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initialize()

        mainViewModel.getRepoList(since = "20").observe(this, Observer {
            //Log.e("response","Sucess")
        })
    }

    private fun initialize() {
        mainAdapter = MainListAdapter()
        rlItems.adapter = mainAdapter
        getDataAndSubscribeEvents()
    }

    private fun getDataAndSubscribeEvents() {
        val repositoriesListLiveData = mainViewModel.getRepoList(since = "20")
        repositoriesListLiveData.observe(this, repositoryObserver)
    }

    private val repositoryObserver = Observer<ResultData<RepositoriesModel?>> { resultData ->
        when(resultData) {
            is ResultData.Loading -> {
               // progressIndicator.show()
            }
            is ResultData.Success -> {
                //progressIndicator.hide()
                val repositoriesModel = resultData.data
                mainAdapter.submitList(repositoriesModel)
            }
            is ResultData.Failed -> {
              //  progressIndicator.hide()
            }
            is ResultData.Exception -> {
              //  progressIndicator.hide()
            }
        }
    }
}


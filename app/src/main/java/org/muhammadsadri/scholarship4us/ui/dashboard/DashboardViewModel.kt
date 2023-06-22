package org.muhammadsadri.scholarship4us.ui.dashboard

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.work.ExistingWorkPolicy
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.muhammadsadri.scholarship4us.databinding.FragmentDashboardBinding
import org.muhammadsadri.scholarship4us.model.Post
import org.muhammadsadri.scholarship4us.network.ApiStatus
import org.muhammadsadri.scholarship4us.network.PostApi
import org.muhammadsadri.scholarship4us.network.UpdateWorker
import java.util.concurrent.TimeUnit

class DashboardViewModel : ViewModel() {
    private val data = MutableLiveData<List<Post>>()
    private val status = MutableLiveData<ApiStatus>()


    init {
        retrieveData()
    }

    private fun retrieveData() {
        viewModelScope.launch(Dispatchers.IO) {
            status.postValue(ApiStatus.LOADING)
            try {
                data.postValue(PostApi.service.getPosts())
                status.postValue(ApiStatus.SUCCESS)
            } catch (e: Exception) {
                Log.d("DasboardViewModel", "Failure: ${e.message}")
                status.postValue(ApiStatus.FAILED)
            }
        }
    }

    fun getData(): LiveData<List<Post>> = data

}
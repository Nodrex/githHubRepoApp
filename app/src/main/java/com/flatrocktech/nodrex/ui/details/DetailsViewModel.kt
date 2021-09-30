package com.flatrocktech.nodrex.ui.details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.flatrocktech.nodrex.models.GithubRepo
import com.flatrocktech.nodrex.repository.Repository
import kotlinx.coroutines.launch

class DetailsViewModel : ViewModel() {

    val repo = MutableLiveData<GithubRepo>()

    fun getRepo(owner: String, repoName: String) {
        viewModelScope.launch {
            repo.value = Repository.getRepo(owner, repoName)
        }
    }
}
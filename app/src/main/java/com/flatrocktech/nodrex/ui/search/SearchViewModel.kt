package com.flatrocktech.nodrex.ui.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.flatrocktech.nodrex.models.GithubRepo
import com.flatrocktech.nodrex.repository.Repository
import kotlinx.coroutines.launch

class SearchViewModel : ViewModel() {

    val repoList = MutableLiveData<List<GithubRepo>>()

    fun getRepoList(user: String) {
        viewModelScope.launch {
            repoList.value = Repository.getRepoList(user)
        }
    }


}
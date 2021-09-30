package com.flatrocktech.nodrex.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.flatrocktech.nodrex.R
import com.flatrocktech.nodrex.databinding.FragmentSearchBinding
import com.flatrocktech.nodrex.models.GithubRepo
import com.flatrocktech.nodrex.ui.details.DetailsViewModel
import com.flatrocktech.nodrex.util.Util

class SearchFragment : Fragment(), View.OnClickListener {

    private lateinit var searchViewModel: SearchViewModel
    private lateinit var detailsViewModel: DetailsViewModel
    private var binding: FragmentSearchBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(inflater, container, false).apply {
            search.setOnClickListener(this@SearchFragment)
            repoRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        }

        searchViewModel = ViewModelProvider(this).get(SearchViewModel::class.java)
        searchViewModel.repoList.observe(viewLifecycleOwner, {
            binding?.progressBar?.visibility = View.GONE
            //Util.log("$it")
            binding?.repoRecyclerView?.adapter = RepoRecyclerViewAdapter(it, this::onItemClick)
        })

        detailsViewModel = ViewModelProvider(requireActivity()).get(DetailsViewModel::class.java)

        return binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    private inline fun onItemClick(githubRepo: GithubRepo){
        detailsViewModel.repo.value = githubRepo
        Util.log("onItemClick $githubRepo")
        Navigation.createNavigateOnClickListener(R.id.action_navigation_search_to_navigation_details)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.search -> search()
        }
    }

    private fun search(){
        if(binding?.searchTextInput?.text == null ) return
        binding?.progressBar?.visibility = View.VISIBLE
        searchViewModel.getRepoList(binding?.searchTextInput?.text.toString())
    }

}
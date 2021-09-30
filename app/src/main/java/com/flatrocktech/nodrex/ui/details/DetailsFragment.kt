package com.flatrocktech.nodrex.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.flatrocktech.nodrex.databinding.FragmentDetailsBinding
import com.flatrocktech.nodrex.models.GithubRepo

class DetailsFragment : Fragment() {

    private lateinit var detailsViewModel: DetailsViewModel
    private var binding: FragmentDetailsBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)

        detailsViewModel = ViewModelProvider(this).get(DetailsViewModel::class.java)
        bindData(detailsViewModel.repo.value)
        detailsViewModel.repo.observe(viewLifecycleOwner, {
            bindData(it)
        })

        return binding?.root
    }

    private fun bindData(githubRepo: GithubRepo?){
        githubRepo?.let {
            binding?.apply {
                textNotifications.text = githubRepo.url
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
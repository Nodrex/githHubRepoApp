package com.flatrocktech.nodrex.ui.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.flatrocktech.nodrex.databinding.RepoItemBinding
import com.flatrocktech.nodrex.models.GithubRepo
import com.squareup.picasso.Picasso

class RepoRecyclerViewAdapter(val data: List<GithubRepo>, val itemCLickListener: (GithubRepo) -> Unit) : RecyclerView.Adapter<RepoRecyclerViewAdapter.ViewHolder>() {

    inner class ViewHolder(val mainView: RepoItemBinding) : RecyclerView.ViewHolder(mainView.root) {

        lateinit var repo: GithubRepo

        init {
            itemView.setOnClickListener {
                itemCLickListener(repo)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        return ViewHolder(RepoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: RepoRecyclerViewAdapter.ViewHolder, position: Int) {
        data[position].let {
            holder.repo = it
            holder.mainView.apply {
                repoName.text = it.name
                userName.text = it.owner.userName
                Picasso.get()
                    .load(it.owner.avatarUrl)
                    .into(avatar)
            }
        }
    }

    override fun getItemCount() = data.size
}
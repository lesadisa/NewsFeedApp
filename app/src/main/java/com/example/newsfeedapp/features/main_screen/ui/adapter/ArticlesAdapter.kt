package com.example.newsfeedapp.features.main_screen.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.newsfeedapp.R
import com.example.newsfeedapp.features.main_screen.domain.model.ArticleDomainModel

class ArticlesAdapter(
    private var articleModels: List<ArticleDomainModel>,
    private val onItemClick: (articleModel: ArticleDomainModel) -> Unit
) :
    RecyclerView.Adapter<ArticlesAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView

        init {
            this.title = view.findViewById<TextView>(R.id.textView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_article, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = articleModels[position].title
        holder.itemView.setOnClickListener { onItemClick(articleModels[position]) }
    }

    override fun getItemCount(): Int {
        return articleModels.size
    }

    fun updateArticles(updatedArticleModels: List<ArticleDomainModel>) {
        articleModels = updatedArticleModels
        notifyDataSetChanged()
    }
}
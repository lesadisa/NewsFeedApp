package com.example.newsfeedapp.features.main_screen.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsfeedapp.R
import com.example.newsfeedapp.features.main_screen.domain.model.ArticleDomainModel

class ArticlesAdapter(
    private var articleModels: List<ArticleDomainModel>,
    private val onItemClick: (articleModel: ArticleDomainModel) -> Unit
) :
    RecyclerView.Adapter<ArticlesAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvTitle: TextView
        val tvDescription: TextView
        val tvPublishedAt: TextView
        val ivImageView: ImageView
        val cbBookmarkIcon: CheckBox

        init {
            this.tvTitle = view.findViewById<TextView>(R.id.textView)
            this.tvDescription = view.findViewById<TextView>(R.id.tvArticleDescription)
            this.tvPublishedAt = view.findViewById<TextView>(R.id.tvArticlePublishedAt)
            this.ivImageView = view.findViewById<ImageView>(R.id.ivArticlePhoto)
            this.cbBookmarkIcon = view.findViewById<CheckBox>(R.id.bookmarkIcon)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_article, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvTitle.text = articleModels[position].title
        holder.tvDescription.text = articleModels[position].description
        holder.tvPublishedAt.text = articleModels[position].publishedAt
        Glide
            .with(holder.ivImageView) // здесь получаете контекст
            .load(articleModels[position].urlToImage)
            .placeholder(R.drawable.ic_placeholder) // плейсхолдер на время пока не загрузится картинка
            .into(holder.ivImageView); //из холдера получаете imageView

        holder.itemView.setOnClickListener {
            onItemClick(articleModels[position])

            /*     holder.biBookmarkIcon.apply {
                     if (article.isBookmarked) {
                         setButtonDrawable(R.drawable.ic_favourite_filled_24dp)
                     } else {
                         setButtonDrawable(R.drawable.ic_favourite_outlined_24dp)
                     }
                 }*/

  // доделать          with(holder) { cbBookmarkIcon.setOnClickListener() }

        }

    }

    override fun getItemCount(): Int {
        return articleModels.size
    }

    fun updateArticles(updatedArticleModels: List<ArticleDomainModel>) {
        articleModels = updatedArticleModels
        //notifyDataSetChanged()  при вызове, он смотрит, какие элементы отображаются на экране в момент его вызова
        // (точнее, какие индексы строк), и вызывает getView() с этими позициями.
        notifyDataSetChanged()
    }
}
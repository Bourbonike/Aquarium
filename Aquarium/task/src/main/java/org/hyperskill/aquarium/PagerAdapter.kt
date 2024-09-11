package org.hyperskill.aquarium

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import org.hyperskill.aquarium.databinding.ItemPageBinding
import org.hyperskill.aquarium.models.Models

class PagerAdapter(private val models: Models) : RecyclerView.Adapter<PageViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PageViewHolder =
        PageViewHolder(ItemPageBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun getItemCount(): Int = models.names.size

    override fun onBindViewHolder(holder: PageViewHolder, position: Int) {
        Picasso.get()
            .load(models.images[position])
            .placeholder(R.drawable.placeholder)
            .error(R.drawable.error)
            .into(holder.binding.imageView, object : Callback {
                override fun onSuccess() {
                }
                override fun onError(e: Exception?) {
                }
            })

        holder.binding.tvName.text = models.names[position]
        holder.binding.tvDescription.text = models.description[position]
    }
}

class PageViewHolder(val binding: ItemPageBinding) : RecyclerView.ViewHolder(binding.root)
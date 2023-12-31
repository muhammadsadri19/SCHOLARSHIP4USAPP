package org.muhammadsadri.scholarship4us.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.muhammadsadri.scholarship4us.R
import org.muhammadsadri.scholarship4us.databinding.ItemPostBinding
import org.muhammadsadri.scholarship4us.model.Post
import org.muhammadsadri.scholarship4us.network.PostApi

class PostAdapter : RecyclerView.Adapter<PostAdapter.ViewHolder>() {
    private val data = mutableListOf<Post>()

    fun updateData(newData: List<Post>) {
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()

    }

    class ViewHolder(private val binding: ItemPostBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(post: Post) = with(binding) {
            tvTitle.text = post.yoast_head_json.title
            tvDate.text = post.date
            Glide.with(imgPost.context)
                .load(PostApi.getPostUrl(post.blog_images.large))
                .error(R.drawable.baseline_broken_image_24)
                .into(imgPost)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemPostBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

}
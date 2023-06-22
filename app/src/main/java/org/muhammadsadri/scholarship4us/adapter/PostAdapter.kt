package org.muhammadsadri.scholarship4us.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.muhammadsadri.scholarship4us.databinding.ItemPostBinding
import org.muhammadsadri.scholarship4us.model.Post

class PostAdapter : RecyclerView.Adapter<PostAdapter.ViewHolder>() {

    private val data = mutableListOf<Post>()

    fun updateData(newData: List<Post>) {
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()

    }

    class ViewHolder(private val binding: ItemPostBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(post: Post) = with(binding) {
            tvTitle.text = post.title.rendered
            tvAuthor.text = post.uagb_author_info.display_name
            tvDate.text = post.date

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
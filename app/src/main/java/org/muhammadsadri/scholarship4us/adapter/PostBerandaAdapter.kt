package org.muhammadsadri.scholarship4us.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.muhammadsadri.scholarship4us.databinding.ItemPostBerandaBinding
import org.muhammadsadri.scholarship4us.databinding.ItemPostBinding
import org.muhammadsadri.scholarship4us.model.Post

class PostBerandaAdapter : RecyclerView.Adapter<PostBerandaAdapter.ViewHolder>(){
    private val data = mutableListOf<Post>()

    fun updateData(newData: List<Post>) {
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()

    }

    class ViewHolder(private val binding: ItemPostBerandaBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(post: Post) = with(binding) {
            tvTitle.text = post.yoast_head_json.title
            tvAuthor.text = post.uagb_author_info.display_name
            tvDate.text = post.date

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemPostBerandaBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }


}
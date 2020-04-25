package com.tomvarga.chatkotlin.chat

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.tomvarga.chatkotlin.databinding.ChatFragmentBinding
import com.tomvarga.chatkotlin.databinding.ChatMessageItemBinding

class ChatAdapter: ListAdapter<ChatMessage, ChatAdapter.ViewHolder>(ChatDiffUtilCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder private constructor(private val binding: ChatMessageItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ChatMessage){
            binding.chatMessage = item
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ChatMessageItemBinding.inflate(layoutInflater,parent,false)
                return ViewHolder(binding)
            }
        }
    }

    class ChatDiffUtilCallback: DiffUtil.ItemCallback<ChatMessage>() {
        override fun areItemsTheSame(oldItem: ChatMessage, newItem: ChatMessage): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ChatMessage, newItem: ChatMessage): Boolean {
            return oldItem.equals(newItem)
        }

    }
}

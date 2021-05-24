package com.emob.etraderdemo.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.emob.etraderdemo.data.model.User
import com.emob.etraderdemo.databinding.ItemLayoutBinding

class MainViewHolder(private val itemBinding: ItemLayoutBinding) : RecyclerView.ViewHolder(itemBinding.root) {

    fun bind(user: User, recyclerItemListener: RecyclerItemListener) {
        itemBinding.textViewUserName.text = user.name
        itemBinding.textViewUserEmail.text = user.email
    }
}
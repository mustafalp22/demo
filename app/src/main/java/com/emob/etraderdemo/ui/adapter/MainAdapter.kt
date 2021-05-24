package com.emob.etraderdemo.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.emob.etraderdemo.R
import com.emob.etraderdemo.data.model.User
import com.emob.etraderdemo.databinding.ItemLayoutBinding

class MainAdapter(
    private val users: ArrayList<User>
) : RecyclerView.Adapter<MainViewHolder>() {

    private val onItemClickListener: RecyclerItemListener = object :
        RecyclerItemListener {
        override fun onItemSelected(recipe: User) {

        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {

        val itemBinding =  ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainViewHolder(itemBinding)
    }

    override fun getItemCount(): Int = users.size


    fun addData(list: List<User>) {
        users.addAll(list)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(users[position], onItemClickListener)
    }


}
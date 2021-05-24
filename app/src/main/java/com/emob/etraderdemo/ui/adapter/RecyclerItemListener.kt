package com.emob.etraderdemo.ui.adapter

import com.emob.etraderdemo.data.model.User

interface RecyclerItemListener {
    fun onItemSelected(user : User)
}
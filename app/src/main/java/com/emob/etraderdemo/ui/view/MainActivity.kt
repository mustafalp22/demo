package com.emob.etraderdemo.ui.view

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.emob.etraderdemo.core.base.BaseActivity
import com.emob.etraderdemo.ui.viewmodel.MainViewState
import com.emob.etraderdemo.data.model.User
import com.emob.etraderdemo.databinding.MainActivityBinding
import com.emob.etraderdemo.ui.adapter.MainAdapter
import com.emob.etraderdemo.ui.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<MainActivityBinding, MainViewModel>({ MainActivityBinding.inflate(it) }) {

    private lateinit var adapter: MainAdapter
    override fun getLifeCycleOwner(): LifecycleOwner = this
    override fun getViewModel(): MainViewModel = ViewModelProvider(this).get(
        MainViewModel::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupUI()
        getViewModel().fetchUsers()

    }

    private fun setupUI() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MainAdapter(arrayListOf())
        binding.recyclerView.addItemDecoration(
            DividerItemDecoration(
                binding.recyclerView.context,
                (binding.recyclerView.layoutManager as LinearLayoutManager).orientation
            )
        )
        binding.recyclerView.adapter = adapter
    }


    override fun onSuccess(data: Any) {

        when (data) {
            is MainViewState.GetUser<*> ->
                renderList( data.data as List<User>)
        }
    }

    override fun onFailure(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show()
    }

    private fun renderList(users: List<User>) {
        adapter.addData(users)
        adapter.notifyDataSetChanged()
    }



}

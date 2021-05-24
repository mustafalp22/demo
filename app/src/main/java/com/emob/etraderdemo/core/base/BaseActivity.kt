package com.emob.etraderdemo.core.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.viewbinding.ViewBinding

abstract class BaseActivity <B : ViewBinding, V : BaseViewModel>(val bindingFactory: (LayoutInflater) -> B) :AppCompatActivity() {

    lateinit var binding: B
    lateinit var mViewModel: V


    abstract fun getViewModel(): V
    abstract fun getLifeCycleOwner(): LifecycleOwner

    /**
    *  Called in case of success or some data emitted from the liveData in viewModel
    */
    open fun onSuccess(data: Any) {}

    /**
     *  Called in case of failure or some error emitted from the liveData in viewModel
     */
    open fun onFailure(error: String) {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpViewBinding()
        mViewModel = getViewModel()
        configureObserver()

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }

    fun setUpViewBinding(){
        binding = bindingFactory(layoutInflater)
        setContentView(binding.root)
    }



    private fun configureObserver() {
        getViewModel().uiState.observe(this, Observer {
            //TODO : hideloading()
            when(it){
                is ViewState.HasData<*> -> it.data?.let { it1 -> onSuccess(it1) }
                is ViewState.HasError -> onFailure(it.error)
            }
        })
    }




}
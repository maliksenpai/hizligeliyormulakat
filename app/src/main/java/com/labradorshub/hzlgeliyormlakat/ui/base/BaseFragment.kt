package com.labradorshub.hzlgeliyormlakat.ui.base

import android.os.Bundle
import android.renderscript.ScriptGroup
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel

abstract class BaseFragment<VDB:ViewDataBinding,VM:BaseViewModel> : Fragment(){
    lateinit var viewModel:VM
    lateinit var binding:VDB

    fun init(inflater : LayoutInflater,container:ViewGroup?){
        binding=DataBindingUtil.inflate(inflater,getLayoutRes(),container,false)
    }

    abstract fun initviewmodel()

    @LayoutRes
    abstract fun getLayoutRes() : Int

    fun lifecyclerowner(){
        binding.lifecycleOwner=this
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        init(inflater,container)
        initviewmodel()
        lifecyclerowner()
        super.onCreateView(inflater, container, savedInstanceState)
        return binding.root
    }


}
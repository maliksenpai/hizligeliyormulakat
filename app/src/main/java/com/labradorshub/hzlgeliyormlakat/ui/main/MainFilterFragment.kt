package com.labradorshub.hzlgeliyormlakat.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.DialogFragment.STYLE_NORMAL
import androidx.fragment.app.Fragment
import com.labradorshub.hzlgeliyormlakat.R
import com.labradorshub.hzlgeliyormlakat.databinding.MainfilterfragmentBinding
import org.koin.android.viewmodel.ext.android.viewModel

class MainFilterFragment() : DialogFragment(){

    val mainViewModel : MainViewModel? by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var binding = DataBindingUtil.inflate<MainfilterfragmentBinding>(inflater,R.layout.mainfilterfragment,null,false)
        binding.viewModel=mainViewModel
        var view = binding.root
        setStyle(STYLE_NORMAL,android.R.style.Theme_Black_NoTitleBar_Fullscreen)
        //var flags = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_FULLSCREEN
        //activity!!.window.decorView.systemUiVisibility = flags
        return binding.root
    }

    override fun onDetach() {
        requireActivity().window.clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        super.onDetach()
    }



}
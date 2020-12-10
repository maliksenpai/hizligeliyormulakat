package com.labradorshub.hzlgeliyormlakat.ui.main

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.labradorshub.hzlgeliyormlakat.R
import com.labradorshub.hzlgeliyormlakat.databinding.ActivityMainBinding
import com.labradorshub.hzlgeliyormlakat.databinding.MainfilterfragmentBinding
import com.labradorshub.hzlgeliyormlakat.model.api.responses.Product
import com.labradorshub.hzlgeliyormlakat.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel
import java.util.zip.Inflater

class MainActivity : BaseActivity<ActivityMainBinding,MainViewModel>(MainViewModel::class.java) {

    val mainViewModel:MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun getLayout(): Int {
        return R.layout.activity_main
    }

    override fun init() {

    }

    override fun initviewmodel() {
        binding.viewModel = mainViewModel
        var recyclerView = mainlist
        recyclerView.layoutManager = GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false)
        mainViewModel.init()
        var bindingfragment = DataBindingUtil.inflate<MainfilterfragmentBinding>(LayoutInflater.from(this),R.layout.mainfilterfragment,null,false)
        bindingfragment.viewModel=mainViewModel
        var dialog = Dialog(this,android.R.style.Theme_Light_NoTitleBar)
        dialog.setContentView(bindingfragment.root)


        mainViewModel.products.observe(this, Observer{
            recyclerView.adapter = MainAdapter(mainViewModel.searched(mainViewModel.text.value!!))
        })

        mainViewModel.filter.observe(this, Observer {
            if(it==true){
                dialog.show()
            }else if(it==false){
                dialog.dismiss()
            }
        })

        mainViewModel.text.observe(this, Observer {
            recyclerView.adapter = MainAdapter(mainViewModel.searched(it))
        })
    }
}
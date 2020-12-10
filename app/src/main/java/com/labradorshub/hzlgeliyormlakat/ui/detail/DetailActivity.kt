package com.labradorshub.hzlgeliyormlakat.ui.detail

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.labradorshub.hzlgeliyormlakat.R
import com.labradorshub.hzlgeliyormlakat.databinding.ActivityDetailBinding
import com.labradorshub.hzlgeliyormlakat.model.api.responses.Product
import com.labradorshub.hzlgeliyormlakat.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_detail.*
import org.koin.android.viewmodel.ext.android.viewModel

class DetailActivity : BaseActivity<ActivityDetailBinding,DetailViewModel>(DetailViewModel::class.java) {

    private val detailViewModel:DetailViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun getLayout(): Int {
        return R.layout.activity_detail
    }

    override fun init() {
        var extras = intent.getParcelableExtra<Product>("product")
        Glide.with(this).load(extras?.image).into(detailimage)
        detailtext.setText(extras?.description)
        detailprice.setText(extras?.price.toString()+"TL")
        supportActionBar?.title=extras?.title
    }

    override fun initviewmodel() {
        binding.viewModel = detailViewModel
        detailViewModel.init()
        detailViewModel.buy.observe(this, Observer {
            if(it==true){
                Toast.makeText(this,"Satın alındı",Toast.LENGTH_SHORT).show()
            }
        })
    }
}
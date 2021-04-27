package com.example.databindingtest.bindingadapter

import android.graphics.Color
import android.text.TextUtils
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.example.databindingtest.R
import com.squareup.picasso.MemoryPolicy
import com.squareup.picasso.NetworkPolicy
import com.squareup.picasso.Picasso

class ImageViewBindingAdapter {

    companion object {
        @JvmStatic
        @BindingAdapter("imgUrl")
        fun setImage(imgView:ImageView, imgUrl: String) {
            if (!TextUtils.isEmpty(imgUrl)){
                Picasso.get().load(imgUrl).networkPolicy(NetworkPolicy.NO_CACHE).memoryPolicy(MemoryPolicy.NO_CACHE).placeholder(R.drawable.ic_launcher_background).error(R.drawable.ic_launcher_foreground).into(imgView)
            }else{
                imgView.setBackgroundColor(Color.DKGRAY)
            }
        }
    }

}
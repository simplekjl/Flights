package com.simplekjl.flights.presentation.utils

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import com.simplekjl.flights.BuildConfig
import com.simplekjl.flights.R
import com.squareup.picasso.Picasso

class BindingUtils {
    companion object {
        @JvmStatic
        @BindingAdapter("android:text")
        fun setFloat(view: TextView, value: Float?) {
            view.text = value?.toInt().toString()
        }

        @JvmStatic
        @InverseBindingAdapter(attribute = "android:text")
        fun getFloat(view: TextView): Float {
            val number = view.text.toString()
            return if (!number.isEmpty()) number.toFloat() else "0.0".toFloat()
        }

        @JvmStatic
        @BindingAdapter("loadImage")
        fun loadImage(view: ImageView, url: String?) {
            url?.let {
                Picasso.get()
                    .load(url)
                    .placeholder(R.drawable.thumbnail)
                    .error(R.drawable.thumbnail)
                    .into(view)
            } ?: run {
                Picasso.get()
                    .load(R.drawable.thumbnail)
                    .placeholder(R.drawable.thumbnail)
                    .error(R.drawable.thumbnail)
                    .into(view)
            }
        }
    }
}
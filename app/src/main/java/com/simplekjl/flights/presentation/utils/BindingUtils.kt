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
            if (url != null) {
                val poserUrl = getPathForImage(url)
                Picasso.get()
                    .load(poserUrl)
                    .placeholder(R.drawable.thumbnail)
                    .error(R.drawable.thumbnail)
                    .into(view)
            } else {
                Picasso.get()
                    .load(R.drawable.thumbnail)
                    .placeholder(R.drawable.thumbnail)
                    .error(R.drawable.thumbnail)
                    .into(view)

            }

        }

        private fun getPathForImage(url: String): String {
            val sb: StringBuilder = StringBuilder(150)
            sb.append(BuildConfig.BASE_IMAGE_URL)
            sb.append(url)
            return sb.toString()
        }
    }
}
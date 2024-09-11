package com.olashiku.newsapp.utils

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.ImageView
import android.widget.Toast
import com.olashiku.newsapp.R
import com.squareup.picasso.Picasso

fun ImageView.loadImage(url: String) {
    if (url.isNotEmpty()) {
        Picasso.get()
            .load(url)
            .placeholder(R.drawable.ic_launcher_foreground)
            .error(R.drawable.ic_launcher_background)
            .into(this)
    }

}

fun Context.openBrowser(url: String) {
    try {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        this.startActivity(browserIntent)
    } catch (e: Exception) {
        Toast.makeText(this, getString(R.string.the_url_you_entered_is_invalid), Toast.LENGTH_SHORT).show()
    }
}

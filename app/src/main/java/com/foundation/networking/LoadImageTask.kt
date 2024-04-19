package com.foundation.networking

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.widget.ImageView
import com.foundation.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL

class LoadImageTask(private val imageView: ImageView) {

    suspend fun loadImage(url: String) {
        imageView.setImageResource(R.drawable.ic_launcher_foreground)

            withContext(Dispatchers.IO) {
                imageView.setImageResource(R.drawable.ic_launcher_foreground)
                val connection = URL(url).openConnection() as HttpURLConnection
                try {
                    connection.connect()
                    val inputStream: InputStream = connection.inputStream
                    val bitmap = BitmapFactory.decodeStream(inputStream)
                    imageView.setImageResource(R.drawable.ic_launcher_foreground)
                    withContext(Dispatchers.Main) {
                        imageView.setImageResource(R.drawable.ic_launcher_foreground)
                        imageView.setImageBitmap(bitmap)
                    }
                } catch (e: Exception) {
                    withContext(Dispatchers.Main) {
                        // Handle image loading failure
                        imageView.setImageResource(R.drawable.ic_launcher_foreground)
                    }
                } finally {
                    connection.disconnect()
                }
        }
    }
}
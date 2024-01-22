package com.example.webeteer.util

import android.content.Context
import com.example.webeteer.view.summary.model.MovieListResponseModel
import com.google.gson.Gson
import java.io.IOException
import java.io.InputStream
import java.nio.charset.Charset

class AssetJsonReader(private val context: Context) {

    fun readJsonFile(fileName: String): String? {

        try {
            val inputStream: InputStream = context.assets.open(fileName)

            val size: Int = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()

            return String(buffer, Charset.defaultCharset())
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return null
    }

    fun parseJsonToObject(jsonString: String?, classOfT: Class<MovieListResponseModel>): MovieListResponseModel {
        return Gson().fromJson(jsonString, classOfT)
    }
}

package com.example.webeteer.repository

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.example.webeteer.util.AssetJsonReader
import com.example.webeteer.view.summary.model.MatchDetails
import com.example.webeteer.view.summary.model.MovieListResponseModel
import javax.inject.Inject

class MatchDataRepo @Inject constructor() {
    val matchSummaryData = MutableLiveData<MatchDetails>()

    fun loadSummaryData(context: Context) {
        val jsonReader = AssetJsonReader(context)
        val jsonString = jsonReader.readJsonFile("source_data.json")
        val myData: MovieListResponseModel = jsonReader.parseJsonToObject(jsonString, MovieListResponseModel::class.java)
        matchSummaryData.value = myData.matchDetails
    }
}
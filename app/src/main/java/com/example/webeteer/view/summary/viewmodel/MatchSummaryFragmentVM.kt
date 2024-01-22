package com.example.webeteer.view.summary.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.webeteer.base.BaseViewModel
import com.example.webeteer.repository.MatchDataRepo
import com.example.webeteer.util.SingleLiveEvent
import com.example.webeteer.view.summary.model.Bowler
import com.example.webeteer.view.summary.model.MatchDetails
import com.example.webeteer.view.summary.model.Player
import com.example.webeteer.view.summary.model.Team
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MatchSummaryFragmentVM @Inject constructor(private val repo: MatchDataRepo) : BaseViewModel() {
    val navigateToScoreCard = SingleLiveEvent<Boolean>()
    val matchSummaryData: LiveData<MatchDetails> get() = repo.matchSummaryData
    private val _teamA = MutableLiveData<Team>()
    val teamA: LiveData<Team> get() = _teamA
    private val _teamB = MutableLiveData<Team>()
    val teamB: LiveData<Team> get() = _teamB
    private val _scoreTeamA = MutableLiveData<String>()
    val scoreTeamA: LiveData<String> get() = _scoreTeamA
    private val _scoreTeamB = MutableLiveData<String>()
    val scoreTeamB: LiveData<String> get() = _scoreTeamB

    init {
        matchSummaryData.observeForever {
            _teamA.value = it.teams[0]
            _teamB.value = it.teams[1]

            _scoreTeamA.value = "${getTotalRuns(it.teams[0].players)}-${it.fallOfWickets[0].wickets.size} (${getTotalOvers(it.teams[0].bowlers)})"
            _scoreTeamB.value =
                "${getTotalRuns(it.teams[1].players)}-${it.fallOfWickets[1].wickets.size} (${getTotalOvers(it.teams[1].bowlers)})"

        }
    }

    fun loadSummaryData(context: Context) {
        repo.loadSummaryData(context)
    }

    fun matchSummaryClick() {
        navigateToScoreCard.value = true
    }

    private fun getTotalRuns(list: List<Player>): String {
        return list.sumOf { it.runs }.toString()
    }


    private fun getTotalOvers(list: List<Bowler>): String {
        return list.sumOf { it.overs }.toString()
    }
}
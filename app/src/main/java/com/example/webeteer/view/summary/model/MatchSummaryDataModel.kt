package com.example.webeteer.view.summary.model

data class MovieListResponseModel(
    val matchDetails: MatchDetails
)

data class MatchDetails(
    val fallOfWickets: List<FallOfWicket>,
    val format: String,
    val teams: List<Team>,
    val toss: String,
    val toss_decision: String
)

data class FallOfWicket(
    val team: String,
    val wickets: List<Wicket>
)

data class Team(
    val bowlers: List<Bowler>,
    val name: String,
    val players: List<Player>
)

data class Wicket(
    val dismissal: Dismissal,
    val overs: Double,
    val player: String,
    val score: Int
)

data class Dismissal(
    val bowler: String,
    val fielder: String,
    val type: String
)

data class Bowler(
    val name: String,
    val overs: Int,
    val runsConceded: Int,
    val wickets: Int
)

data class Player(
    val balls: Int,
    val dismissal: Dismissal,
    val fours: Int,
    val name: String,
    val runs: Int,
    val sixes: Int
)
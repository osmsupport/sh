package com.example.webeteer.util

import androidx.databinding.BindingAdapter
import com.example.webeteer.view.summary.model.Bowler
import com.example.webeteer.view.summary.model.Dismissal
import com.example.webeteer.view.summary.model.Player
import com.google.android.material.textview.MaterialTextView
import java.math.BigDecimal
import java.math.RoundingMode

object BindingUtil {


    @BindingAdapter("battingDismissal")
    @JvmStatic
    fun setBattingDismissal(view: MaterialTextView, value: Dismissal) {
        view.text = when (value.type) {
            "Caught" -> {
                "c ${value.fielder} b ${value.bowler}"
            }

            "Run Out" -> {
                "run out (${value.fielder})"
            }

            "Bowled" -> {
                "b ${value.bowler}"
            }

            "Stumped" -> {
                "run out (${value.fielder})"
            }

            "LBW" -> {
                "LBW b ${value.bowler}"
            }

            else -> {
                ""
            }
        }
    }

    @BindingAdapter("strikeRate")
    @JvmStatic
    fun setStrikeRate(view: MaterialTextView, value: Player) {
        val divide: Float = value.runs.toFloat() / value.balls.toFloat()
        val bigDecimal = BigDecimal((divide * 100).toDouble())
        view.text = bigDecimal.setScale(1, RoundingMode.HALF_EVEN).toString()
    }

    @BindingAdapter("economyRate")
    @JvmStatic
    fun setEconomyRate(view: MaterialTextView, value: Bowler) {
        view.text = (value.runsConceded.toFloat() / value.overs.toFloat()).toString()
    }
}
package com.example.megamillions

import com.example.megamillions.domain.CustomBallPicker
import com.example.megamillions.domain.SimulationRunner
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.text.NumberFormat
import java.time.Duration
import java.time.LocalDateTime

class TestBallPicker {
    @Test
    fun drawNormalBallsReturnsCorrectNumberOfBalls(){
        val bp = CustomBallPicker(totalBalls = 70, numBallsToDraw = 5, totalSpecialBalls = 25)
        bp.normalBalls.forEach { println(it) }
        println("special: ${bp.specialBall}")
    }


    @Test
    fun runSim(){
        val sim = SimulationRunner()
        val numSimulations = 1000000000L
        val startTime = LocalDateTime.now()
        println("NumSimulations: ${NumberFormat.getInstance().format(numSimulations)}")
        println("StartTime: $startTime")
        sim.simulate(numSimulations)
        val endTime = LocalDateTime.now()
        val totalTime = Duration.between(endTime, startTime)
        println("totalTime: $totalTime")
        println("totalWinnings: ${NumberFormat.getInstance().format(sim.totalWinnings)}")
        println("totalSpent: ${NumberFormat.getInstance().format(numSimulations * 2)}")
        println("numJackpots: ${NumberFormat.getInstance().format(sim.numJackpots)}")
        println("numberOfWins: ${NumberFormat.getInstance().format(sim.numberOfWins)}")

        println()
        println("jackpot% Theirs: ${1.0 / 302575350.0} - mine: ${sim.numJackpots.toDouble() / numSimulations.toDouble()}")
        println("any% Theirs: ${1.0 / 24.0} - mine: ${sim.numberOfWins.toDouble() / numSimulations.toDouble()}")
    }

}
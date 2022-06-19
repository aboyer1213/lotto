package com.example.megamillions

import com.example.megamillions.model.MegaMillionsLottoGame
import com.example.megamillions.model.MegaMillionsWinningsCalculator
import com.example.megamillions.model.SimulationRunner
import com.example.megamillions.view.ConsoleStatsViewer
import org.junit.jupiter.api.Test
import java.text.NumberFormat
import java.time.Duration
import java.time.LocalDateTime

class TestLottoGame {

    @Test
    fun runSim(){
        val sim = SimulationRunner(MegaMillionsLottoGame(), 4, MegaMillionsWinningsCalculator())
        val numSimulations = 100000000L
        val startTime = LocalDateTime.now()
        println("NumSimulations: ${NumberFormat.getInstance().format(numSimulations)}")
        println("StartTime: $startTime")
        println()
        sim.simulate(numSimulations)
        val endTime = LocalDateTime.now()
        val totalTime = Duration.between(endTime, startTime)
        println()
        println("totalTime: $totalTime")

        val consoleViewer = ConsoleStatsViewer()
        consoleViewer.displayStats(sim)
    }

}
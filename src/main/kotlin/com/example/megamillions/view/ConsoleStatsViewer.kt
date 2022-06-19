package com.example.megamillions.view

import com.example.megamillions.model.Simulation
import java.text.NumberFormat

class ConsoleStatsViewer : StatsViewer {
    override fun displayStats(sim: Simulation){
        println("-----------------------------------------------------------------------------------------------")
        println("Sim Identifier: ${sim.identifier}")
        println("totalWinnings: ${NumberFormat.getInstance().format(sim.totalWinnings)}")
        println("totalSpent: ${NumberFormat.getInstance().format(sim.numRuns * sim.lottoGame.ticketCost)}")
        println("numJackpots: ${NumberFormat.getInstance().format(sim.numJackpots)}")
        println("numberOfWins: ${NumberFormat.getInstance().format(sim.numberOfWins)}")
        println("actualNumSimulations: ${NumberFormat.getInstance().format(sim.numRuns)}")

        println()
        println("jackpot% Theirs: ${1.0 / 302575350.0} - mine: ${sim.numJackpots.toDouble() / sim.numRuns.toDouble()}")
        println("any% Theirs: ${1.0 / 24.0} - mine: ${sim.numberOfWins.toDouble() / sim.numRuns.toDouble()}")
        println("-----------------------------------------------------------------------------------------------")
    }
}
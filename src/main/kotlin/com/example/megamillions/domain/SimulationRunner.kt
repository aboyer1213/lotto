package com.example.megamillions.domain

import org.springframework.context.annotation.Scope

@Scope("singleton")
class SimulationRunner(override val lottoGame: LottoGame) : Simulation {
    override val identifier = "mother-runner"
    override val jackpot = 3000000L
    override var totalWinnings = 0L
    override var numJackpots = 0
    override var numberOfWins = 0L
    override var numRuns = 0L

    fun simulate(numSimulations: Long) {
        val numThreads = 4
        val interval = numSimulations / numThreads

        var threads: ArrayList<SimulationRunnable> = ArrayList<SimulationRunnable>()
        for (i in 1 .. numSimulations step interval) {
            threads.add (SimulationRunnable(lottoGame, jackpot, interval, this))
        }
        threads.forEach { it.start() }
        threads.forEach {it.join()}

    }

    @Synchronized
    fun updateStats(threadTotalWinnings: Long, threadNumberOfWins: Long, threadNumJackpots: Int, threadNumRuns: Long) {
        totalWinnings += threadTotalWinnings
        numberOfWins += threadNumberOfWins
        numJackpots += threadNumJackpots
        numRuns += threadNumRuns
    }

}
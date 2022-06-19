package com.example.megamillions.model.impl

import com.example.megamillions.model.LottoGame
import com.example.megamillions.model.RandomLottoGenerator
import com.example.megamillions.model.Simulation
import com.example.megamillions.model.WinningsCalculator
import com.example.megamillions.view.ConsoleStatsViewer
import com.example.megamillions.view.StatsViewer
import java.time.LocalDateTime

class SimulationRunnable(
    override val lottoGame: LottoGame,
    override val jackpot: Long,
    override var numRuns: Long,
    private val simRunner: SimulationRunner, // TODO autowire?
    override val winningsCalculator: WinningsCalculator
) : Runnable, Simulation {
    override val identifier: String = Thread.currentThread().id.toString()
    override var totalWinnings = 0L
    override var numJackpots = 0
    override var numberOfWins = 0L
    private val viewer: StatsViewer = ConsoleStatsViewer() // TODO autowire
    val t = Thread(this)
    override fun run() {
        println("starting thread ${Thread.currentThread()} : ${LocalDateTime.now()}")
        for (i in 1 .. numRuns) {
            val ticket = RandomLottoGenerator(lottoGame)
            val drawing = RandomLottoGenerator(lottoGame)
            val winnings = winningsCalculator.calculateWinnings(ticket, drawing, jackpot)
            totalWinnings += winnings

            if (winnings > 0) {
                numberOfWins++
            }
            if (winnings == jackpot) {
                numJackpots++
            }
        }
        simRunner.updateStats(totalWinnings, numberOfWins, numJackpots, numRuns)
        println("Done thread ${Thread.currentThread()} : ${LocalDateTime.now()}")
        viewer.displayStats(this)
    }
    fun start() {
        t.start()
    }
    fun join() {
        t.join()
    }
}
package com.example.megamillions.domain

import com.example.megamillions.view.ConsoleStatsViewer
import java.time.LocalDateTime

class SimulationRunnable(
    override val lottoGame: LottoGame,
    override val jackpot: Long,
    override var numRuns: Long,
    private val simRunner: SimulationRunner, // TODO autowire
) : Runnable, Simulation{
    override val identifier: String = Thread.currentThread().id.toString()
    override var totalWinnings = 0L
    override var numJackpots = 0
    override var numberOfWins = 0L
    private val viewer: StatsViewer = ConsoleStatsViewer() // TODO autowire
    val t = Thread(this)
    override fun run() {
        println("starting thread ${Thread.currentThread()} : ${LocalDateTime.now()}")
        for (i in 1 .. numRuns) {
            val ticket = RandomLottoBallGenerator(lottoGame)
            val drawing = RandomLottoBallGenerator(lottoGame)
            val wc = MegaMillionsWinningsCalculator()
            val winnings = wc.calculateWinnings(ticket, drawing, jackpot)
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
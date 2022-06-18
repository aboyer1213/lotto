package com.example.megamillions.domain

interface Simulation {
    val identifier: String
    val lottoGame: LottoGame
    val jackpot: Long
    var totalWinnings: Long
    var numJackpots: Int
    var numberOfWins: Long
    var numRuns: Long
}
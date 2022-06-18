package com.example.megamillions.domain

class SimulationRunner {
    val jackpot = 3000000L
    var totalWinnings = 0L
    var numJackpots = 0
    var numberOfWins = 0

    fun simulate(numSimulations: Long) {
       val ticket = CustomBallPicker(totalBalls = 70, numBallsToDraw = 5, totalSpecialBalls = 25)

        for (i in 1 .. numSimulations) {
            val drawing = CustomBallPicker(totalBalls = 70, numBallsToDraw = 5, totalSpecialBalls = 25)
            val winnings= calculateWinnings(ticket, drawing)
            totalWinnings += winnings

            if (winnings > 0) {
                numberOfWins++
            }
            if (winnings == jackpot) {
                numJackpots++
            }

        }
    }

    fun calculateWinnings(ticket: CustomBallPicker, drawing: CustomBallPicker): Long {
        var numMatches = 0
        for (ticketVal in ticket.normalBalls) {
            if (drawing.normalBalls.contains(ticketVal)){
                numMatches++
            }
        }

        var specialMatches = ticket.specialBall == drawing.specialBall

        return when {
            numMatches == 0 && specialMatches -> 2
            numMatches == 1 && specialMatches -> 4
            numMatches == 2 && specialMatches -> 10
            numMatches == 3 && !specialMatches -> 10
            numMatches == 3 && specialMatches -> 200
            numMatches == 4 && !specialMatches -> 500
            numMatches == 4 && specialMatches -> 10000
            numMatches == 5 && !specialMatches -> 1000000
            numMatches == 5 && specialMatches -> jackpot
            else -> 0
        }

    }
}
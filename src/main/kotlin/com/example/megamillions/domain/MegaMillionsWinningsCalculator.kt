package com.example.megamillions.domain

class MegaMillionsWinningsCalculator: WinningsCalculator {
    override fun calculateWinnings(ticket: RandomLottoBallGenerator, drawing: RandomLottoBallGenerator, jackpot: Long): Long {
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
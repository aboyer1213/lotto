package com.example.megamillions.model

interface WinningsCalculator {
    fun calculateWinnings(ticket: RandomLottoGenerator, drawing: RandomLottoGenerator, jackpot: Long): Long
}
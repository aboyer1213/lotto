package com.example.megamillions.domain

interface WinningsCalculator {
    fun calculateWinnings(ticket: RandomLottoBallGenerator, drawing: RandomLottoBallGenerator, jackpot: Long): Long
}
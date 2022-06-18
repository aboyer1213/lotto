package com.example.megamillions.domain

interface LottoGame {
    val totalBalls: Int
    val numBallsToDraw: Int
    val totalSpecialBalls: Int
    val ticketCost: Double
}
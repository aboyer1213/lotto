package com.example.megamillions.model

interface LottoGame {
    val totalBalls: Int
    val numBallsToDraw: Int
    val totalSpecialBalls: Int
    val ticketCost: Double
}
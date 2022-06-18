package com.example.megamillions.domain

class MegaMillionsLottoGame : LottoGame{
    override val totalBalls = 70
    override val numBallsToDraw = 5
    override val totalSpecialBalls = 25
    override val ticketCost = 2.0
}
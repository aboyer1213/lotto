package com.example.megamillions.model

class RandomLottoGenerator(val lottoGame: LottoGame){

    val normalBalls: Array<Int>
    val specialBall: Int
    init {
        if (lottoGame.totalBalls <= 0 || lottoGame.numBallsToDraw <= 0 || lottoGame.numBallsToDraw > lottoGame.totalBalls){
            throw java.lang.IllegalArgumentException()
        }
        normalBalls = drawNormalBalls()
        specialBall = drawSpecialBall()
    }

    fun drawSpecialBall(): Int {
        return (1 .. lottoGame.totalSpecialBalls).random()
    }

    fun drawNormalBalls(): Array<Int> {

        val ballsDrawn = Array(lottoGame.numBallsToDraw) {i -> i}
        for (i in 0 until lottoGame.numBallsToDraw){
           var rand = (1..lottoGame.totalBalls).random()
           while(ballsDrawn.contains(rand)){
               rand = (1 .. lottoGame.totalBalls).random()
           }
           ballsDrawn[i] = rand
        }
        return ballsDrawn
    }
}
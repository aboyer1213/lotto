package com.example.megamillions.domain

import lombok.With
import org.springframework.context.annotation.Scope

class CustomBallPicker(
    @With val totalBalls: Int,
    @With val numBallsToDraw: Int,
    @With val totalSpecialBalls: Int,

    )  {
    @With val normalBalls: Array<Int?>
    @With val specialBall: Int
    init {
        normalBalls = drawNormalBalls()
        specialBall = drawSpecialBall()
    }

    private fun drawSpecialBall(): Int {
        return (1 .. totalSpecialBalls).random()
    }

    private fun drawNormalBalls(): Array<Int?> {

        val ballsDrawn = arrayOfNulls<Int>(numBallsToDraw)
        for (i in 0 until numBallsToDraw){
           var rand = (1..totalBalls).random()
           while(ballsDrawn.contains(rand)){
               rand = (1 .. totalBalls).random()
           }
           ballsDrawn[i] = rand
        }
        return ballsDrawn
    }
}
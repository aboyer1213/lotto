package com.example.megamillions.domain

import org.springframework.context.annotation.Scope

interface BallPicker {
    val numBalls: Int
    val numDrawn: Int
    val numSpecialBalls: Int
    val normalBalls: Array<Int>
    val specialBall: Int
    fun drawNormalBalls(): Array<Int>
    fun drawSpecialBall(): Int

}
package com.example.megamillions.view

import com.example.megamillions.model.Simulation

interface StatsViewer {
    fun displayStats(simulation: Simulation);
}
package com.nordsec.locationapp.data

import kotlin.math.pow

fun distance(fromLat: Double, fromLon: Double, toLat: Double, toLon: Double): Double {
    val radius = 6378137.0
    val deltaLat = toLat - fromLat
    val deltaLon = toLon - fromLon
    val angle = 2 * Math.asin(
        Math.sqrt(
            Math.sin(deltaLat / 2).pow(2.0) +
                    Math.cos(fromLat) * Math.cos(toLat) *
                    Math.sin(deltaLon / 2).pow(2.0)
        )
    )
    return radius * angle
}
package com.jlahougue.run.domain

import com.jlahougue.core.domain.location.LocationTimestamp
import kotlin.time.Duration

data class RunData(
    val distanceMeter: Int = 0,
    val pace: Duration = Duration.ZERO,
    val locations: List<List<LocationTimestamp>> = emptyList()
)

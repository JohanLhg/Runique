package com.jlahougue.run.presentation.run_overview.mapper

import com.jlahougue.core.domain.run.Run
import com.jlahougue.core.presentation.ui.formatted
import com.jlahougue.core.presentation.ui.toFormattedKm
import com.jlahougue.core.presentation.ui.toFormattedKmh
import com.jlahougue.core.presentation.ui.toFormattedMeters
import com.jlahougue.core.presentation.ui.toFormattedPace
import com.jlahougue.run.presentation.run_overview.model.RunUi
import java.time.ZoneId
import java.time.format.DateTimeFormatter

fun Run.toRunUi(): RunUi {
    val dateTimeLocal = dateTimeUtc
        .withZoneSameInstant(ZoneId.systemDefault())
    val formattedDateTime = DateTimeFormatter
        .ofPattern("MMM dd, yyyy - hh:mma")
        .format(dateTimeLocal)

    val distanceKm = distanceMeters / 1000.0

    return RunUi(
        id = id!!,
        duration = duration.formatted(),
        dateTime = formattedDateTime,
        distance = distanceKm.toFormattedKm(),
        avgSpeed = avgSpeedKmh.toFormattedKmh(),
        maxSpeed = maxSpeedKmh.toFormattedKmh(),
        pace = duration.toFormattedPace(distanceKm),
        totalElevation = totalElevationMeters.toFormattedMeters(),
        mapPictureUrl = mapPictureUrl
    )
}
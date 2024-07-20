package com.jlahougue.run.network

import com.jlahougue.core.domain.location.Location
import com.jlahougue.core.domain.run.Run
import java.time.Instant
import java.time.ZoneId
import kotlin.time.Duration.Companion.milliseconds

fun RunDto.toRun() = Run(
    id = id,
    duration = durationMillis.milliseconds,
    dateTimeUtc = Instant.parse(dateTimeUtc)
        .atZone(ZoneId.of("UTC")),
    distanceMeters = distanceMeters,
    location = Location(
        latitude = lat,
        longitude = long
    ),
    maxSpeedKmh = maxSpeedKmh,
    totalElevationMeters = totalElevationMeters,
    mapPictureUrl = mapPictureUrl
)

fun Run.toCreateRunRequest() = CreateRunRequest(
    id = id!!,
    durationMillis = duration.inWholeMilliseconds,
    epochMillis = dateTimeUtc.toEpochSecond() * 1000,
    distanceMeters = distanceMeters,
    lat = location.latitude,
    long = location.longitude,
    avgSpeedKmh = avgSpeedKmh,
    maxSpeedKmh = maxSpeedKmh,
    totalElevationMeters = totalElevationMeters
)
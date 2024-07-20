package com.jlahougue.core.database.mappers

import com.jlahougue.core.database.entity.RunEntity
import com.jlahougue.core.domain.location.Location
import com.jlahougue.core.domain.run.Run
import org.bson.types.ObjectId
import java.time.Instant
import java.time.ZoneId
import kotlin.time.Duration.Companion.milliseconds

fun RunEntity.toRun() = Run(
    id = id,
    duration = durationMillis.milliseconds,
    dateTimeUtc = Instant.parse(dateTimeUtc)
        .atZone(ZoneId.of("UTC")),
    distanceMeters = distanceMeters,
    location = Location(
        latitude = latitude,
        longitude = longitude
    ),
    maxSpeedKmh = maxSpeedKmh,
    totalElevationMeters = totalElevationMeters,
    mapPictureUrl = mapPictureUrl
)

fun Run.toRunEntity() = RunEntity(
    id = id ?: ObjectId().toHexString(),
    durationMillis = duration.inWholeMilliseconds,
    dateTimeUtc = dateTimeUtc.toInstant().toString(),
    distanceMeters = distanceMeters,
    latitude = location.latitude,
    longitude = location.longitude,
    avgSpeedKmh = avgSpeedKmh,
    maxSpeedKmh = maxSpeedKmh,
    totalElevationMeters = totalElevationMeters,
    mapPictureUrl = mapPictureUrl
)
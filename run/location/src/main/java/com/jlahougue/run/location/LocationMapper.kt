package com.jlahougue.run.location

import android.location.Location
import com.jlahougue.core.domain.location.LocationWithAltitude
import com.jlahougue.core.domain.location.Location as DomainLocation

fun Location.toLocationWithAltitude(): LocationWithAltitude {
    return LocationWithAltitude(
        DomainLocation(
            latitude = latitude,
            longitude = longitude,
        ),
        altitude = altitude
    )
}
package com.lauwba.wisatakita.destinasi

import com.google.android.gms.maps.model.LatLng

data class Destinasi(
    var namaDestinasi: String,
    var rating: Double,
    var fotoDestinasi: String,
    var coordinate: LatLng,
    var location: String
)

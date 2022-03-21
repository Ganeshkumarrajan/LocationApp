package com.nordsec.locationapp.data.model

import com.google.gson.annotations.SerializedName

data class Locations(@SerializedName("locations") val location: List<Location>)

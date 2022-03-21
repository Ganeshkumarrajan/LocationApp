package com.nordsec.locationapp.data.dataSource

import android.content.Context
import com.google.gson.Gson
import com.nordsec.locationapp.data.model.Locations
import io.reactivex.rxjava3.core.Observable
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

class LocationDataSourceImpl(context: Context) : LocationDataSource {
    private val inputStream: InputStream = context.assets.open("data.json")
    private val bufferReader = BufferedReader(InputStreamReader(inputStream))
    private val locations: Locations = Gson().fromJson(bufferReader, Locations::class.java)

    override fun getLocation(): Observable<Locations> = Observable.just(locations)
}

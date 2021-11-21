package ir.behnawwm.golestanhelper.data.api

import ir.behnawwm.golestanhelper.data.models.DaneshjooData
import retrofit2.http.GET

interface ApiService {

    @GET("/behnawwm/GolestanHelper/master/data/daneshjoo.json")
    suspend fun getDaneshjooData(): List<DaneshjooData>

    @GET("/behnawwm/GolestanHelper/master/data/ostad.json")
    suspend fun getOstadData(): List<DaneshjooData>
}
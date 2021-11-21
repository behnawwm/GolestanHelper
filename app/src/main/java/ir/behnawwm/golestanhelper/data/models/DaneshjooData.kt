package ir.behnawwm.golestanhelper.data.models

import com.google.gson.annotations.SerializedName

data class DaneshjooData(
    val name: String,
    val code: Int,
    @SerializedName("people_type") val peopleType: Int,
    @SerializedName("type_name") val typeName: String
) {

}

package ir.behnawwm.golestanhelper.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Request(
    @PrimaryKey(autoGenerate = true) var requestId: Long = 0,
    val code: Int,
    val title: String,
    val peopleType: Int,    //todo define Enums
    val type: Int,           //todo define Enums
    val isFavorite: Boolean = false,

    var hint: String? = null,
    var desc: String? = null,
    var path: String? = null,
    var timesVisited: Int? = null,
    var lastSearchedTime: Long? = null,
)
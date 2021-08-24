package ir.behnawwm.golestanhelper.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Request(
    @PrimaryKey(autoGenerate = true) var requestId:Long = 0,
    var code: Int,
    var title: String,
    var hint: String? = null,
    var desc: String? = null,
    var path: String? = null,
    var timesVisited: Int? = null,
    var isFavorite: Boolean? = null,
    var lastSearchedTime: Long? = null
)
package ir.behnawwm.golestanhelper.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Type(
    @PrimaryKey(autoGenerate = true) var typeId: Long,
    var title: String
)
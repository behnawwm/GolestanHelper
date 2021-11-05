package ir.behnawwm.golestanhelper.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Role(
    @PrimaryKey(autoGenerate = true) var roleId: Long,
    var title: String
) {
}
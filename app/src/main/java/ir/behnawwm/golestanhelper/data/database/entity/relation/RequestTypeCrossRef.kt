package ir.behnawwm.golestanhelper.data.database.entity.relation

import androidx.room.Entity

@Entity(primaryKeys = ["requestId", "typeId"])
data class RequestTypeCrossRef(
    val requestId: Long,
    val typeId: Long
)
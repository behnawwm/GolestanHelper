package ir.behnawwm.golestanhelper.data.database.entity.relation

import androidx.room.Entity

@Entity(primaryKeys = ["requestId", "roleId"])
data class RequestRoleCrossRef(
    val requestId: Long,
    val roleId: Long
)
package ir.behnawwm.golestanhelper.database.entity.relation

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import ir.behnawwm.golestanhelper.database.entity.Request
import ir.behnawwm.golestanhelper.database.entity.Role

data class RoleWithRequests(
    @Embedded val role: Role,
    @Relation(
        parentColumn = "roleId",
        entityColumn = "requestId",
        associateBy = Junction(RequestRoleCrossRef::class)
    )
    val requests: List<Request>
)

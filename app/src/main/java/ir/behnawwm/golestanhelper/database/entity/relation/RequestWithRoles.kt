package ir.behnawwm.golestanhelper.database.entity.relation

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import ir.behnawwm.golestanhelper.database.entity.Request
import ir.behnawwm.golestanhelper.database.entity.Role

data class RequestWithRoles(
    @Embedded val request: Request,
    @Relation(
        parentColumn = "requestId",
        entityColumn = "roleId",
        associateBy = Junction(RequestRoleCrossRef::class)
    )
    val types: List<Role>
)

package ir.behnawwm.golestanhelper.data.database.entity.relation

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import ir.behnawwm.golestanhelper.data.database.entity.Request
import ir.behnawwm.golestanhelper.data.database.entity.Type

data class TypeWithRequests(
    @Embedded val type: Type,
    @Relation(
        parentColumn = "typeId",
        entityColumn = "requestId",
        associateBy = Junction(RequestTypeCrossRef::class)
    )
    val requests: List<Request>
)

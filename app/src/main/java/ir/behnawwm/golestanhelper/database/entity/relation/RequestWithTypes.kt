package ir.behnawwm.golestanhelper.database.entity.relation

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import ir.behnawwm.golestanhelper.database.entity.Request
import ir.behnawwm.golestanhelper.database.entity.Type

data class RequestWithTypes(
    @Embedded val request: Request,
    @Relation(
        parentColumn = "requestId",
        entityColumn = "typeId",
        associateBy = Junction(RequestTypeCrossRef::class)
    )
    val types: List<Type>
)

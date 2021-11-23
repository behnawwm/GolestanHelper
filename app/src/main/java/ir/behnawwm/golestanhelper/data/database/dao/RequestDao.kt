package ir.behnawwm.golestanhelper.data.database.dao

import androidx.room.*
import ir.behnawwm.golestanhelper.data.database.entity.Request
import ir.behnawwm.golestanhelper.data.database.entity.Type
import ir.behnawwm.golestanhelper.data.database.entity.relation.RequestTypeCrossRef
import ir.behnawwm.golestanhelper.data.database.entity.relation.RequestWithTypes
import ir.behnawwm.golestanhelper.data.database.entity.relation.TypeWithRequests

@Dao
interface RequestDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRequest(users: Request)

    //    @Insert
//    suspend fun insertType(vararg type: Type)
//
//    @Insert
//    suspend fun insertRequestTypeCrossRef(vararg crossRef: RequestTypeCrossRef)
//
//    @Transaction
//    @Query("SELECT * FROM type WHERE typeId = :typeId")
//    suspend fun getRequestsOfType(typeId: Long): List<TypeWithRequests>
//
//    @Transaction
//    @Query("SELECT * FROM request WHERE requestId = :requestId")
//    suspend fun getTypesOfRequest(requestId: Long): List<RequestWithTypes>

    @Query("SELECT * FROM Request WHERE peopleType = :peopleType")
    suspend fun getAllRequests(peopleType: Int): List<Request>
}
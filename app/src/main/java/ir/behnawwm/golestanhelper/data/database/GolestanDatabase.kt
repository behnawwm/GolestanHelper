package ir.behnawwm.golestanhelper.data.database

import android.content.Context
import androidx.room.*
import ir.behnawwm.golestanhelper.data.database.entity.Request
import ir.behnawwm.golestanhelper.data.database.entity.Role
import ir.behnawwm.golestanhelper.data.database.entity.Type
import ir.behnawwm.golestanhelper.data.database.entity.relation.RequestRoleCrossRef
import ir.behnawwm.golestanhelper.data.database.entity.relation.RequestTypeCrossRef
import ir.behnawwm.golestanhelper.data.database.dao.RequestDao

@Database(
    entities = [
        Request::class,
        Type::class,
        Role::class,
        RequestTypeCrossRef::class,
        RequestRoleCrossRef::class
    ],
    version = 1
)
abstract class GolestanDatabase : RoomDatabase() {
    abstract val requestDao: RequestDao

    companion object {
        @Volatile
        private var INSTANCE: GolestanDatabase? = null

        fun getInstance(context: Context): GolestanDatabase {
            synchronized(this) {
                return INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    GolestanDatabase::class.java,
                    "golestan_db"
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }

}



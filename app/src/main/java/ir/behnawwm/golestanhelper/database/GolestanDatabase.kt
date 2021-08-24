package ir.behnawwm.golestanhelper.database

import android.content.Context
import androidx.room.*
import ir.behnawwm.golestanhelper.database.entity.Request
import ir.behnawwm.golestanhelper.database.entity.Role
import ir.behnawwm.golestanhelper.database.entity.Type
import ir.behnawwm.golestanhelper.database.entity.relation.RequestRoleCrossRef
import ir.behnawwm.golestanhelper.database.entity.relation.RequestTypeCrossRef
import ir.behnawwm.golestanhelper.database.dao.RequestDao

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



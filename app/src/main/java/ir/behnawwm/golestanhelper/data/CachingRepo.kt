package ir.behnawwm.golestanhelper.data

import ir.behnawwm.golestanhelper.data.api.ApiService
import ir.behnawwm.golestanhelper.data.database.dao.RequestDao
import ir.behnawwm.golestanhelper.data.database.entity.Request
import ir.behnawwm.golestanhelper.data.models.DaneshjooData
import ir.behnawwm.golestanhelper.prefs
import javax.inject.Inject

class CachingRepo @Inject constructor(
    val api: ApiService,
    val dao: RequestDao
) {

    suspend fun loadDbFromApi() {
        val list = getAllData()

        list.forEach {
            val type = if (it.typeName == "پردازش") 1 else 2    //todo enum
            insertRequest(
                Request(
                    code = it.code,
                    title = it.name,
                    type = type,
                    peopleType = it.peopleType,
                )
            )
        }
    }

    private suspend fun getAllData(): List<DaneshjooData> =
        api.getDaneshjooData() + api.getOstadData()

    private suspend fun insertRequest(request: Request) {
        dao.insertRequest(request)
    }

    suspend fun getAllDataFromDb(): List<Request> = dao.getAllRequests(prefs.intPeopleType)

}
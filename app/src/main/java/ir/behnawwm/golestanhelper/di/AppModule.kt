package ir.behnawwm.golestanhelper.di

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.behnawwm.golestanhelper.data.CachingRepo
import ir.behnawwm.golestanhelper.data.api.ApiService
import ir.behnawwm.golestanhelper.data.database.GolestanDatabase
import ir.behnawwm.golestanhelper.data.database.dao.RequestDao
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        val client = OkHttpClient.Builder().build()

        return Retrofit.Builder()
            .baseUrl("https://raw.githubusercontent.com/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService =
        retrofit.create(ApiService::class.java)

    @Provides
    @Singleton
    fun provideDatabase(
        app: Application,
    ) = GolestanDatabase.getInstance(app)


    @Provides
    @Singleton
    fun provideDao(db: GolestanDatabase) = db.requestDao


    //    //Repository
    @Singleton
    @Provides
    fun provideValidationRepo(
        apiService: ApiService,
        dao: RequestDao
    ) =
        CachingRepo(apiService, dao)
}
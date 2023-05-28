package com.example.codigocodetest_zwn.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.codigocodetest_zwn.model.MovieModel
import kotlinx.coroutines.CoroutineScope

@Database(entities = [MovieModel::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        @Synchronized
        fun getDatabase(context: Context, scope: CoroutineScope): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext, AppDatabase::class.java, "movie_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }

//        private class RoomCallBack (val scope: CoroutineScope):RoomDatabase.Callback() {
//            override fun onCreate(db: SupportSQLiteDatabase) {
//                super.onCreate(db)
//                INSTANCE.let {
//
//                }
//            }
//        }
    }
}
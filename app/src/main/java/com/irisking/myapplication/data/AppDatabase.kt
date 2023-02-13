package com.irisking.myapplication.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.irisking.myapplication.data.bean.History
import com.irisking.myapplication.data.dao.HistoryDao
import kotlin.jvm.internal.Intrinsics

/**
 *
 *
 * @author tangzhaoqiang
 * @since 2023-02-02
 */
@Database(entities = [History::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun historyDao(): HistoryDao

    companion object {
        private const val DATABASE_NAME = "history.db"
        private lateinit var mPersonDatabase: AppDatabase

        private val MIGRATION_2_3 = object : Migration(2, 3) {
            override fun migrate(database: SupportSQLiteDatabase) {
                Intrinsics.checkNotNullParameter(database, "database")
                database.execSQL("ALTER TABLE T_AC_PersonAuthPeriod ADD COLUMN FStatus INTEGER DEFAULT 0")
            }
        }

        //注意：如果您的应用在单个进程中运行，在实例化 AppDatabase 对象时应遵循单例设计模式。
        //每个 RoomDatabase 实例的成本相当高，而您几乎不需要在单个进程中访问多个实例
        fun getInstance(context: Context): AppDatabase {
            if (!this::mPersonDatabase.isInitialized) {
                //创建的数据库的实例
                mPersonDatabase = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    DATABASE_NAME
                )
//                    .addMigrations(MIGRATION_2_3)
                    .build()
            }
            return mPersonDatabase
        }
    }

}
package com.example.cobalagi.Dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Dosen::class, Matakuliah::class], version = 1, exportSchema = false)
abstract class dataBase : RoomDatabase()
{

    // Mendefinisikan fungsi untuk mengakses DAO
    abstract fun dosenDao(): DosenDao
    abstract fun mataKuliahDao(): MatakuliahDao

    companion object {
        @Volatile
        private var INSTANCE: kuliah? = null

        fun getDatabase(context: Context): kuliah {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    kuliah::class.java, // Class database
                    "kuliah" // Nama database
                ).build().also { INSTANCE = it }
            }
        }
    }
}

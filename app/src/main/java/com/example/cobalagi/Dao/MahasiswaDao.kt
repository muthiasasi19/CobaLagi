package com.example.cobalagi.Dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao // semua operasi ada di Dao
interface MahasiswaDao {

    @Insert
    suspend fun  insertMahasiswa(mahasiswa: Mahasiswa)

    // Untuk mengambil semua data mahasiswa yang tersimpan berdasarkan nama secara ascending (ASC)
    @Query("SELECT * FROM mahasiswa ORDER BY nama ASC")
    fun getAllMahasiswa() : Flow<List<Mahasiswa>>

    // untuk mengambil data mahasiswa bedasarkan NIM
    @Query("SELECT * FROM mahasiswa WHERE nim = :nim")
    fun getMahasiswa(nim : String) : Flow<Mahasiswa>

    // Untuk menghapus data mahasiswa tertentu dari database
    @Delete
    suspend fun deleteMahasiswa(mahasiswa: Mahasiswa)

    // untuk memperbarui informasi mahasiswa yang sudah ada di database
    @Update
    suspend fun updateMahasiswa(mahasiswa: Mahasiswa)

}
//-----------------------------------------------------------------------
/*
Urutan file yang perlu  dibuat:

Data Layer: Entity, DAO, Database.
Repository: LocalRepository, Repository.
ViewModel: ViewModel untuk setiap tampilan.
UI Layer: Screens (Home, Detail, Insert, Update, dll.).
MainActivity: Menghubungkan UI dengan ViewModel.
Dependency Injection: Untuk mengelola dependensi aplikasi secara terpusat.
*/
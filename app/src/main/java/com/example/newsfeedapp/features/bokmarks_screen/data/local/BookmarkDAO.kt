package com.example.newsfeedapp.features.bokmarks_screen.data.local

import androidx.room.*


@Dao
interface BookmarkDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun create(entity: BookmarksEntity)

    @Query("SELECT * FROM ${BookmarksEntity.TABLE_NAME}")
    suspend fun read(): List<BookmarksEntity>

    @Update
    suspend fun update(entity: BookmarksEntity)

    @Delete
    suspend fun delete(entity: BookmarksEntity)
}
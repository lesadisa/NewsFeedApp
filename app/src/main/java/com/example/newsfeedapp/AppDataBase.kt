package com.example.newsfeedapp

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.newsfeedapp.features.bokmarks_screen.data.local.BookmarkDAO
import com.example.newsfeedapp.features.bokmarks_screen.data.local.BookmarksEntity

@Database(entities = [BookmarksEntity::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun bookmarksDAO() : BookmarkDAO
}
package edu.quaglia.notesapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class NotesDB : RoomDatabase() {
    abstract fun getNotesDao() : NotesDao

    companion object {
        @Volatile
        private var INSTANCE: NotesDB? = null

        fun getDatabase(context: Context): NotesDB {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(context, NotesDB::class.java, "note_database").build()
                INSTANCE = instance
                instance
            }
        }
    }
}
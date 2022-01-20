package edu.quaglia.notesapp

class NotesRepository(private val notesDao: NotesDao) {

    val allNotes by lazy { notesDao.getAll() }

    suspend fun insert(note: Note) {
        notesDao.insert(note)
    }

    suspend fun update(note: Note){
        notesDao.update(note)
    }

    suspend fun delete(note: Note) {
        notesDao.delete(note)
    }
}

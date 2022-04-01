package controllers
private var notes = ArrayList<Note>()
class NoteAPI {
    fun add(note: Note): Boolean {
        return notes.add(note)
    }

}

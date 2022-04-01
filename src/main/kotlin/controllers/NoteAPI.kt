package controllers


import models.Note


private var notes = ArrayList<Note>()
class NoteAPI {
    fun add(note: Note): Boolean {
        return notes.add(note)
    }

    fun numberOfNotes(): Int {
        return notes.size
    }

    fun findNote(index: Int): Note? {
        return if (isValidListIndex(index, notes)) {
            notes[index]
        } else null
    }

    //utility method to determine if an index is valid in a list.
    fun isValidListIndex(index: Int, list: List<Any>): Boolean {
        return (index >= 0 && index < list.size)
    }
    fun listActiveNotes(): String {
        return if (numberOfActiveNotes() == 0) {
            "No active notes stored"
        } else {
            var listOfActiveNotes = ""
            for (note in notes) {
                if (!note.isNoteArchived) {
                    listOfActiveNotes += "${notes.indexOf(note)}: $note \n"
                }
            }
            listOfActiveNotes
        }
    }

    fun listArchivedNotes(): String {
        return if (numberOfArchivedNotes() == 0) {
            "No archived notes stored"
        } else
    {
        var listOfArchivedNotes = ""
        for (note in notes) {
            if (note.isNoteArchived) {
                listOfArchivedNotes += "${notes.indexOf(note)}: $note \n"
            }
        }
        listOfArchivedNotes
    }
    }
    }

    fun numberOfArchivedNotes(): Int {
        var counter = 0
        for (note in notes) {
            if (note.isNoteArchived) {
                counter++
            }
        }
        return counter

        //helper method to determine how many archived notes there are
    }

    fun numberOfActiveNotes(): Int {
        var counter = 0
        for (note in notes) {
            if (!note.isNoteArchived) {
                counter++
            }
        }
        return counter
        //helper method to determine how many active notes there are
    }
fun listNotesBySelectedPriority(priority: Int): String {
    return if (notes.isEmpty()) {
        "No notes stored"
    } else {
        var listOfNotes = ""
        for (i in notes.indices) {
            if (notes[i].notePriority == priority) {
                listOfNotes +=
                    """$i: ${notes[i]}
                        """.trimIndent()
            }
        }
        if (listOfNotes.equals("")) {
            "No notes with priority: $priority"
        } else {
            "${numberOfNotesByPriority(priority)} notes with priority $priority: $listOfNotes"
        }
    }
}

fun numberOfNotesByPriority(): Int {
    var counter = 0
    for (note in notes) {
        if (note.notePriority == priority) {
            counter++
        }
    }
    return counter
    //helper method to determine how many notes there are of a specific priority
}

fun deleteNote(indexToDelete: Int): Note? {
    return if (isValidListIndex(indexToDelete, notes)) {
        notes.removeAt(indexToDelete)
    } else null
}



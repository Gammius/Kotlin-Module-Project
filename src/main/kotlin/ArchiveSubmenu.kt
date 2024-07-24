class ArchiveSubmenu(
    private val archiveName: String,
    private val archiveNotes: MutableMap<String, MutableList<String>>,
    private val menuUtils: MenuUtils,
    private val menuManager: MenuManager
) {
    fun showSubmenu() {
        val header = "Архив: $archiveName"
        val options = mutableListOf<Pair<String, () -> Unit>>()

        options.add("Создать заметку" to ::createNote)
        archiveNotes[archiveName]?.forEach { note ->
            val noteTitle = note.split(":")[0]
            options.add(noteTitle to { menuManager.showMenu { NoteMenu(noteTitle, note, menuUtils, menuManager).showNoteMenu() } })
        }
        options.add("Назад" to menuManager::goBack)

        menuUtils.showMenuAndGetChoice(header, options)
    }
    private fun createNote() {
        println("Создание новой заметки в архиве \"$archiveName\"")
        val noteTitle = menuUtils.readNonEmptyLine("Введите заголовок заметки: ")
        val noteContent = menuUtils.readNonEmptyLine("Введите содержание заметки: ")
        val newNote = "$noteTitle: $noteContent"
        archiveNotes[archiveName]?.add(newNote)
        println("Заметка \"$noteTitle\" успешно создана.")
        showSubmenu()
    }
}
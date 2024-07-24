class NoteMenu(
    private val noteTitle: String,
    private val note: String,
    private val menuUtils: MenuUtils,
    private val menuManager: MenuManager
) {
    fun showNoteMenu() {
        val header = "Название заметки: $noteTitle"
        val options = mutableListOf<Pair<String, () -> Unit>>()

        options.add("Посмотреть заметку" to ::viewNote)
        options.add("Назад" to menuManager::goBack)

        menuUtils.showMenuAndGetChoice(header, options)
    }
    private fun viewNote() {
        println("Заголовок заметки: $noteTitle")
        println("Содержание заметки: ${note.split(":")[1].trim()}")
        showNoteMenu()
    }
}
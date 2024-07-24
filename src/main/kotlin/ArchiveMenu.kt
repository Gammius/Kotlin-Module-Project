class ArchiveMenu(
    private val archives: MutableList<String>,
    private val archiveNotes: MutableMap<String, MutableList<String>>,
    private val menuManager: MenuManager
) {
    private val menuUtils = MenuUtils()
    fun showArchiveMenu() {
        val header = "Архивы:"
        val options = mutableListOf<Pair<String, () -> Unit>>()

        options.add("Создать архив" to ::createArchive)
        archives.forEach { archive ->
            options.add(archive to { menuManager.showMenu { ArchiveSubmenu(archive, archiveNotes, menuUtils, menuManager).showSubmenu() } })
        }
        options.add("Выход" to menuManager::goBack)

        menuUtils.showMenuAndGetChoice(header, options)
    }
    private fun createArchive() {
        println("Создание нового архива")
        val newArchiveName = menuUtils.readNonEmptyLine("Введите название архива: ")
        archives.add(newArchiveName)
        archiveNotes[newArchiveName] = mutableListOf()
        println("Архив \"$newArchiveName\" успешно создан.")
        showArchiveMenu()
    }
}
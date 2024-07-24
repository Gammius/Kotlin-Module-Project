fun main() {
    val archives = mutableListOf<String>()
    val archiveNotes = mutableMapOf<String, MutableList<String>>()
    val menuManager = MenuManager()
    val archiveMenu = ArchiveMenu(archives, archiveNotes, menuManager)
    menuManager.showMenu { archiveMenu.showArchiveMenu() }
}
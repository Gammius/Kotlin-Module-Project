import kotlin.system.exitProcess
import java.util.Stack
class MenuManager {
    private val menuStack = Stack<() -> Unit>()
    fun showMenu(menu: () -> Unit) {
        menuStack.push(menu)
        menu.invoke()
    }
    fun goBack() {
        if (menuStack.isNotEmpty()) {
            menuStack.pop()
        }
        if (menuStack.isNotEmpty()) {
            menuStack.peek().invoke()
        } else {
            println("Выход из приложения.")
            exitProcess(0)
        }
    }
}
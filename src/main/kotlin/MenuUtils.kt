class MenuUtils {
    fun <T> showMenuAndGetChoice(header: String, options: List<Pair<String, () -> T>>): T? {
        println(header)
        options.forEachIndexed { index, option ->
            println("${index + 1}. ${option.first}")
        }
        print("Выберите пункт меню: ")

        val input = readLine()?.toIntOrNull()
        if (input == null) {
            println("Неверный ввод, пожалуйста, введите число.")
            return showMenuAndGetChoice(header, options)
        }

        if (input in 1..options.size) {
            return options[input - 1].second()
        } else {
            println("Нет такого пункта, пожалуйста, введите корректный номер пункта.")
            return showMenuAndGetChoice(header, options)
        }
    }

    fun readNonEmptyLine(prompt: String): String {
        print(prompt)
        var input: String? = null
        while (input.isNullOrBlank()) {
            input = readLine()?.trim()
            if (input.isNullOrBlank()) {
                println("Пожалуйста, введите непустую строку.")
            }
        }
        return input
    }
}
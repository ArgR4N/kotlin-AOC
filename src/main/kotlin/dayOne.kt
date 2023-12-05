import java.io.File

fun dayOne(): String {
    val projectPath = System.getProperty("user.dir")
    val input = File("$projectPath/src/main/resources/dayOne.txt").readText()

    val numbers = (1..9).map { it.toString()[0] }

    var res = 0;
    input.split("\n").map { line -> line.filter { it in numbers  } }
        .forEach {line ->
            if(line.isEmpty()) return@forEach;
            res += when (line.length > 1) {
                true -> line.withIndex().filter { it.index == 0 || it.index == line.length-1 }
                    .map { it.value }.joinToString("").toInt() //Get first and last digit
                false -> line.toInt()*11 //Doble the digit
            }
        }

    return res.toString()
}
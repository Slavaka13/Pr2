fun main() {
    //Вывод инфы
    println("Введите первый массив (через пробел):")
    val array1 = readLine()!!.split(" ").map { it.toInt() }.toIntArray()
    println("Введите второй массив (через пробел):")
    val array2 = readLine()!!.split(" ").map { it.toInt() }.toIntArray()
    val intersection = getIntersection(array1, array2)
    println("Пересечение массивов: ${intersection.contentToString()}")
}
// Взял два массива и вернул третий новый)
fun getIntersection(array1: IntArray, array2: IntArray): IntArray {
    val frequencyMap1 = mutableMapOf<Int, Int>()
    val frequencyMap2 = mutableMapOf<Int, Int>()

    // Считаю кол-во вхождений уникальных
    for (num in array1) {
        frequencyMap1[num] = (frequencyMap1[num] ?: 0) + 1
    }
    for (num in array2) {
        frequencyMap2[num] = (frequencyMap2[num] ?: 0) + 1
    }

    // Финальный массив массива :))))
    val intersection = mutableListOf<Int>()
    for (num in frequencyMap1.keys) {
        if (frequencyMap2.containsKey(num)) {
            val count = minOf(frequencyMap1[num]!!, frequencyMap2[num]!!)
            for (i in 0 until count) {
                intersection.add(num)
            }
        }
    }

    return intersection.toIntArray()
}

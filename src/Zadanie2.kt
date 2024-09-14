import kotlin.random.Random

fun isSymmetricRelativeToMainDiagonal(matrix: Array<IntArray>): Boolean {
    if (matrix.size != matrix[0].size) { // Если не квадратная
        return false
    }

    for (i in matrix.indices) {
        for (j in i until matrix[i].size) {
            if (matrix[i][j] != matrix[j][i]) {
                // Если не симметричны
                return false
            }
        }
    }

    return true  
}

fun GeneraciaChisel(size: Int): Array<IntArray> {
    val matrix = Array(size) { IntArray(size) }
    for (i in matrix.indices) {
        for (j in matrix[i].indices) {
            matrix[i][j] = Random.nextInt(1, 11)
        }
    }
    return matrix
}

fun main() {
    val randomMatrix = GeneraciaChisel(5)
    println("Случайная матрица:")
    randomMatrix.forEach { row -> println(row.contentToString()) }

    println("Матрица симметрична относительно главной диагонали? ${isSymmetricRelativeToMainDiagonal(randomMatrix)}")
}

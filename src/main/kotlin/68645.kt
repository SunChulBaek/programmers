/**
 * 삼각 달팽이
 */
fun main(args: Array<String>) {
    // 문제
    val n: Int = 10
    // 결과
    val answer = IntArray(size(n))
    val triangle = Array(n) { floor -> IntArray(floor + 1) }
    var number = 1
    var shell = 0
    for (i in 0 until n) {
        val x = i.mod(3)
        for (j in 0 until n - i) {
            println("i = $i, j = $j, shell = $shell")
            if (x == 0) {
                triangle[j + shell * 2][shell] = number++
            } else if (x == 1) {
                triangle[n - shell - 1][j + shell + 1] = number++
            } else {
                triangle[n - (i + j - shell * 2)][n - (i + j - shell)] = number++
            }
            print(triangle)
        }
        if (x == 2) {
            shell++
        }
    }
    triangle.forEachIndexed { i, line ->
        println("$i = ${line.fold("") { acc, i -> "$acc, $i"}}")
    }
    var index = 0;
    triangle.forEach { line ->
        line.forEach { number ->
            answer[index++] = number
        }
    }
}

fun size(n: Int): Int {
    return (n + 1) * (n /2 ) + (if(n.mod(2) == 0) 0 else (n/2 + 1))
}
fun print(triangle: Array<IntArray>) {
    triangle.forEachIndexed { i, line ->
        println("$i = ${line.fold("") { acc, i -> "$acc, $i"}}")
    }
}
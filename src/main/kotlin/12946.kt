/**
 * 하노이의 탑
 */
fun main(args: Array<String>) {
    // 문제
    val n: Int = 3
    // 결과
    val answer = recursive(1, 3, n)

    answer.forEach {
        it.forEach { print("$it, ") }
        println()
    }
}

fun recursive(from: Int, to: Int, n: Int): Array<IntArray> {
    val middle = (3 + 2 + 1) - from - to
    val ret = mutableListOf<IntArray>()
    if (n > 1) {
        ret.addAll(recursive(from, middle, n - 1))
    }
    ret.add(intArrayOf(from, to))
    if (n > 1) {
        ret.addAll(recursive(middle, to, n - 1))
    }
    return ret.toTypedArray()
}
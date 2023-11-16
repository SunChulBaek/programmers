/**
 * 명예의 전당 (1)
 */
fun main(args: Array<String>) {
    // 문제
    val k: Int = 3
    val score: IntArray = intArrayOf(10, 100, 20, 150, 1, 100, 200)
    // 결과
    var answer : IntArray = List(score.size) { i ->
        score.toList().subList(0, i + 1).sortedDescending().let {
            it[if (it.size >= k) k - 1 else it.size - 1]
        }
    }.toIntArray()
    println(answer)
}
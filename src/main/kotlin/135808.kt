/**
 * 과일 장수
 **/
fun main(args: Array<String>) {
    val k: Int = 3
    val m: Int = 4
    val score: IntArray = intArrayOf(1, 2, 3, 1, 2, 3, 1)
    var answer: Int = 0
    score.sortDescending()
    for (i in 0 until score.size / m) {
        answer += score[(i * m) + (m - 1)] * m
    }
}
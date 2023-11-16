/**
 * 약수의 개수와 덧셈
 */
fun main(args: Array<String>) {
    val left = 13
    val right = 17
    var answer: Int = 0
    for (num in left .. right) {
        val isJegop = Math.sqrt(num.toDouble()).mod(1.0) != 0.0
        answer += (if (isJegop) 1 else -1) * num
    }
}
/**
 * 안전지대
 */
fun main(args: Array<String>) {
    // 문제
    val board: Array<IntArray> = arrayOf(
        intArrayOf(0, 0, 0, 0, 0),
        intArrayOf(0, 0, 0, 0, 0),
        intArrayOf(0, 0, 0, 0, 0),
        intArrayOf(0, 0, 1, 1, 0),
        intArrayOf(0, 0, 0, 0, 0),
    )
    // 결과
    var answer: Int = 0
    val n = board.size
    board.forEachIndexed { i, row ->
        row.forEachIndexed { j, point ->
            if (point == 1) {
                // 윗줄
                if (i > 0) {
                    val upRow = board[i - 1]
                    if (j - 1 >= 0 && upRow[j - 1] == 0)
                        upRow[j - 1] = 2
                    if (upRow[j] == 0)
                        upRow[j] = 2
                    if (j + 1 <= n -1 && upRow[j + 1] == 0)
                        upRow[j + 1] = 2
                }
                // 양옆
                if (j - 1 >= 0 && row[j - 1] == 0)
                    row[j - 1] = 2
                if (j + 1 <= n - 1 && row[j + 1] == 0)
                    row[j + 1] = 2
                // 아랫줄
                if (i < n - 1) {
                    val downRow = board[i + 1]
                    if (j -1 >= 0 && downRow[j - 1] == 0)
                        downRow[j - 1] = 2
                    if (downRow[j] == 0)
                        downRow[j] = 2
                    if (j + 1 <= n -1 && downRow[j + 1] == 0)
                        downRow[j + 1] = 2
                }
            }
        }
    }
    board.forEach {
        it.forEach {
            print(it)
        }
        println()
    }
    answer = board.fold(0) { totalSum, row ->
        totalSum + row.fold(
            0
        ) { rowSum, pos -> rowSum + if (pos == 0) 1 else 0 }
    }
    println(answer)
}
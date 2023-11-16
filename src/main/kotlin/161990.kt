/**
 * 바탕화면 정리
 **/
fun main(args: Array<String>) {
    // 문제
    val wallpaper: Array<String>  = arrayOf()
    // 결과
    var answer: IntArray = intArrayOf()

    var lux = -1;
    var luy = -1;
    var rdx = -1;
    var rdy = -1;
    wallpaper.forEachIndexed { x, row ->
        row.toCharArray().forEachIndexed { y, char ->
            if (char == '#') {
                if (lux == -1 || x < lux) {
                    lux = x
                }
                if (luy == -1 || y < luy) {
                    luy = y
                }
                if (rdx == -1 || x + 1 > rdx) {
                    rdx = x + 1
                }
                if (rdy == -1 || y +1 > rdy) {
                    rdy = y + 1
                }
            }
        }
    }
    answer = intArrayOf(lux, luy, rdx, rdy)
}
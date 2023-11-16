/**
 * 외계어 사전
 */
fun main(args: Array<String>) {
    // 문제
    val spell = arrayOf("p", "o", "s")
    val dic = arrayOf("sod", "eocd", "qixm", "adio", "soo")
    // 결과
    var answer: Int = 2

    spell.sort()
    val sortedSpell = spell.fold("") { result, c -> result + c}
    dic.forEach { word ->
        if (word.length == spell.size) {
            val wordArray = word.toCharArray()
            wordArray.sort()
            val sortedWord = wordArray.fold("") { result, c -> result + c }
            println("sortedSpell = $sortedSpell, sortedWord = $sortedWord")
            if (sortedWord == sortedSpell) {
                answer = 1
            }
        }
    }
}
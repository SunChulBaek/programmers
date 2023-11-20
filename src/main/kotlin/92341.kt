/**
 * 주차 요금 계산
 */
fun main(args: Array<String>) {
    // 문제
    val fees: IntArray = intArrayOf(180, 5000, 10, 600)
    val records: Array<String> = arrayOf("05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT")
    // 결과
    var answer: IntArray = IntArray(1000)
    val events = mutableMapOf<String, Int>() // 차량번호, 시간
    val result = mutableMapOf<String, Int>() // 차량번호, 누적시간

    val maxTime = (60 * 23) + 59
    val defaultTime = fees[0]
    val defaultFee = fees[1]
    val unitTime = fees[2]
    val unitFee = fees[3]

    records.forEach { record ->
        val splits = record.split(" ")
        val time = splits[0].let { 60 * it.split(":")[0].toInt() + it.split(":")[1].toInt() }
        val carId = splits[1]
        val event = splits[2]
        if (events.containsKey(carId)) {
            result[carId] = (result[carId] ?: 0) + (time - events[carId]!!)
            events.remove(carId)
        } else {
            events[carId] = time
        }
    }
    events.forEach { (carId, time) ->
        result[carId] = (result[carId] ?: 0) + (maxTime - events[carId]!!)
    }
    var index = 0
    result.toSortedMap().forEach { (carId, acc) ->
        val fee = defaultFee + (if (acc > defaultTime) Math.ceilDiv(acc - defaultTime ,unitTime) * unitFee else 0)
        answer[index++] = fee
    }
}
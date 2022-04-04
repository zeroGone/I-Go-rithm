package programmers

fun main() {
    println(
        신고결과받기().solution(
            arrayOf("con", "ryan"),
            arrayOf("ryan con", "ryan con", "ryan con", "ryan con"),
            3
        ).toList()
    )
}

class 신고결과받기 {
    fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
        val answer = id_list.map { 0 }.toIntArray()

        val reportedMap = hashMapOf<String, MutableSet<String>>()
        val reportNumberMap = hashMapOf<String, Int>()

        for (reporter in id_list) {
            reportedMap[reporter] = hashSetOf()
            reportNumberMap[reporter] = 0
        }

        report.map { it.split(" ") }
            .forEach {
                val reporter = it[0]
                val reported = it[1]

                if (!reportedMap[reported]!!.contains(reporter)) {
                    reportedMap[reported]!! += reporter
                    reportNumberMap.computeIfPresent(reported) { _, number -> number + 1 }
                }
            }

        reportNumberMap.forEach { (reported, number) ->
            if (number >= k) {
                reportedMap[reported]!!.forEach {
                    answer[id_list.indexOf(it)] += 1
                }
            }
        }

        return answer
    }
}
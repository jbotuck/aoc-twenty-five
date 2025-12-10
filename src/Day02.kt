fun main() {
    fun solve(isBadId: (String) -> Boolean) {
        readInput("Day02").first().split(",")
            .flatMap { range ->
                range.split("-")
                    .map { it.toLong() }
                    .let { (start, end) ->
                        start.rangeTo(end)
                            .map { it.toString() }
                            .filter(isBadId)
                            .map { it.toLong() }
                    }
            }.sum()
            .println()
    }
    solve {
        val half = it.length / 2
        it.take(half) == it.drop(half)
    }
    solve { id ->
        1.until(id.length)
            .filter { id.length % it == 0 }
            .any { subLength ->
                0.until(id.length / subLength)
                    .map { id.substring(0 + it * subLength, it.inc() * subLength) }
                    .let { subs -> subs.all { it == subs[1] } }
            }
    }
}

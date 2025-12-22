fun main() {
    fun neighbors(y: Int, x: Int): Sequence<Pair<Int, Int>> = sequenceOf(
        Pair(y.dec(), x.dec()),
        Pair(y.dec(), x),
        Pair(y.dec(), x.inc()),
        Pair(y, x.dec()),
        Pair(y, x.inc()),
        Pair(y.inc(), x.dec()),
        Pair(y.inc(), x),
        Pair(y.inc(), x.inc())
    )

    fun solve1() {
        val grid = readInput("Day04")
        grid.withIndex().sumOf { (y, line) ->
            line.withIndex().count { (x, c) ->
                c == '@' && neighbors(y, x).count { (y, x) -> grid.getOrNull(y)?.getOrNull(x) == '@' } < 4
            }
        }.println()
    }
    solve1()
    val grid = readInput("Day04").map { it.toCharArray() }.toTypedArray()
    var checkAgain = true
    var countRemoved = 0
    while (checkAgain) {
        checkAgain = false
        for (y in grid.indices) {
            for (x in grid[y].indices) {
                if (grid[y][x] == '@' && neighbors(y, x).count { (y, x) ->
                    grid.getOrNull(y)?.getOrNull(x) == '@'
                } < 4) {
                    checkAgain = true
                    grid[y][x] = '.'
                    countRemoved++
                }
            }
        }
    }
    println(countRemoved)

}

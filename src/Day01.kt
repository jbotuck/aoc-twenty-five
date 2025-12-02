import kotlin.math.sign

fun main() {
    fun part1(input: List<Int>): Int {
        return input.runningFold(50) { pos, rotation ->
            pos.plus(rotation) % 100
        }.count { it == 0 }
    }

    fun part2(input: List<Int>): Int {
        var count = 0
        var pos = 50
        for (rotation in input) {
            val sign = rotation.sign
            var ticks = rotation
            while (ticks != 0){
                pos = pos.plus(sign) % 100
                if (pos == 0) count++
                ticks -= sign
            }
        }
        return count
    }

    val input = readInput("Day01")
        .map { it.drop(1).toInt() * if (it.first() == 'R') 1 else -1 }
    part1(input).println()
    part2(input).println()
}

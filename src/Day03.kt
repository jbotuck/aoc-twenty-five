fun main() {
    fun solve(numberOfBatteriesToTurnOn: Int = 2) {
        readInput("Day03").sumOf { line ->
            sequence {
                var batteriesRemaining = line
                for(numberOfBatteriesOffLimits in numberOfBatteriesToTurnOn.dec().downTo(0)){
                    val joltage = batteriesRemaining.dropLast(numberOfBatteriesOffLimits).max()
                    yield(joltage)
                    batteriesRemaining = batteriesRemaining.substringAfter(joltage)
                }
            }.joinToString("").toLong()
        }.println()
    }
    solve()
    solve(12)
}

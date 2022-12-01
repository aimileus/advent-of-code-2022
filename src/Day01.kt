fun main() {
    fun elves(input: List<String>) =
        input.map { it.toIntOrNull() }.splitOnNull().map { it.sum() }

    fun part1(input: List<String>): Int {
        return elves(input).max()
    }

    fun part2(input: List<String>): Int {
        return elves(input).sortedDescending().take(3).sum()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 24000)
    check(part2(testInput) == 45000)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}

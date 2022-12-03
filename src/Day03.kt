fun main() {
    fun getPriority() =
        "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".withIndex()
            .associate { (i, c) -> c to i + 1 }

    fun prioritySum(it: String): Int {
        val priority = getPriority()
        val length = it.length / 2

        return (it.subSequence(0, length).toSet() intersect it.substring(
            length, 2 * length
        ).toSet()).sumOf { priority[it]!! }
    }

    fun part1(input: List<String>): Int {
        return input.sumOf { prioritySum(it) }
    }

    fun part2(input: List<String>): Int {
        val priority = getPriority()

        return input.map { it.toSet() }.chunked(3).map {
            it.reduce { acc, chars -> acc intersect chars }.iterator().next()
        }.sumOf { priority[it]!! }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03_test")
    check(part1(testInput) == 157)
    check(part2(testInput) == 70)

    val input = readInput("Day03")
    println("Part 1: ${part1(input)}")
    println("Part 2: ${part2(input)}")
}

fun <T> List<T>.toPair(): Pair<T, T> {
    val (a, b) = this
    return Pair(a, b)
}

fun main() {
    fun pairs(input: List<String>) = input.map {
        it.split(",", limit = 2)
            .map {
                it.split("-", limit = 2)
                    .map(String::toInt).toPair()
            }.toPair()
    }

    fun part1(input: List<String>): Int {
        return pairs(input)
            .map { (p1, p2) ->
                (p1.first <= p2.first && p2.second <= p1.second)
                        || (p2.first <= p1.first) && (p1.second <= p2.second)
            }
            .count { it }
    }

    fun part2(input: List<String>): Int {
        return pairs(input)
            .map { (p1, p2) -> p1.second < p2.first || p2.second < p1.first }
            .count { !it }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day04_test")
    checkTest("Test part 1", part1(testInput), 2)
    checkTest("Test part 2", part2(testInput), 4)

    val input = readInput("Day04")
    println("Part 1: ${part1(input)}")
    println("Part 2: ${part2(input)}")
}

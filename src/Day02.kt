enum class RPS {
    Rock,
    Paper,
    Scissors;

    fun score(): Int {
        return if (this == Rock) {
            1
        } else if (this == Paper) {
            2
        } else {
            3
        }
    }

    fun winTo(): RPS {
        return if (this == Rock) {
            Scissors
        } else if (this == Paper) {
            Rock
        } else {
            Paper
        }
    }

    fun looseTo(): RPS {
        return this.winTo().winTo()
    }

    fun winFrom(other: RPS): Boolean {
        return other == this.winTo()
    }

    fun battle(other: RPS): Int {
        return if (this.winFrom(other)) {
            6
        } else if (this == other) {
            3
        } else {
            assert(other.winFrom(this))
            0
        }
    }
}

fun main() {
    fun points(i: String): Int {
        val (opp, play) = i.split(" ", limit = 2).map { it.toRPS() }

        return play.score() + play.battle(opp)
    }

    fun part1(input: List<String>): Int {
        return input.sumOf { points(it) }
    }

    fun points2(i: String): Int {
        val (opp, resp) = i
            .split(" ", limit = 2)
            .let { (it1, it2) -> Pair(it1.toRPS(), it2) }

        val play = when (resp) {
            "X" -> opp.winTo()
            "Y" -> opp
            "Z" -> opp.looseTo()
            else -> throw Exception()
        }

        return play.score() + play.battle(opp)
    }

    fun part2(input: List<String>): Int {
        return input.sumOf { points2(it) }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 15)
    check(part2(testInput) == 12)

    val input = readInput("Day02")
    println("Part 1: ${part1(input)}")
    println("Part 2: ${part2(input)}")
}

fun String.toRPS(): RPS {
    return if (this == "A" || this == "X") {
        RPS.Rock
    } else if (this == "B" || this == "Y") {
        RPS.Paper
    } else if (this == "C" || this == "Z") {
        RPS.Scissors
    } else {
        throw Exception()
    }
}

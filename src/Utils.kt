import java.io.File

/**
 * Reads lines from the given input txt file.
 */
fun readInput(name: String) = File("data", "$name.txt").readLines()

fun <T> Iterable<T>.splitOn(el: T): Sequence<List<T>> {
    return sequence {
        var cur = mutableListOf<T>()
        for (x in this@splitOn) {
            if (x == el) {
                yield(cur)
                cur = mutableListOf()
            } else {
                cur.add(x)
            }
        }

        yield(cur)
    }
}

fun <T> Iterable<T?>.splitOnNull(): Sequence<List<T>> {
    @Suppress("UNCHECKED_CAST")
    return this.splitOn(null) as Sequence<List<T>>
}

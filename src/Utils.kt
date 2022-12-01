import java.io.File
import java.math.BigInteger
import java.security.MessageDigest

/**
 * Reads lines from the given input txt file.
 */
fun readInput(name: String) = File("src", "$name.txt").readLines()

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

/**
 * Converts string to md5 hash.
 */
fun String.md5(): String = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray())).toString(16)

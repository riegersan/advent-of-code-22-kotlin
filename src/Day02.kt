import kotlin.Exception

fun main() {

    fun getPoints(e: Int, i: Int): Int {
        if(e == i){ //draw
            return i + 3
        }

        if(e == 3){
            if(i == 1){
                return 7
            }
        }

        if(e == 1){
            if(i == 3){
                return 3
            }
        }

        if(e > i){
            return i
        }

        if(e < i) {
            return i + 6
        }

        throw Exception("Nope")
    }

    fun part1(input: List<String>): Int {
        return input.map {
            it.split(" ").map {
                when(it){
                    "A" -> 1 // rock
                    "B" -> 2 // paper
                    "C" -> 3 // scissors
                    "X" -> 1 // rock
                    "Y" -> 2 // paper
                    "Z" -> 3 // scissors
                    else -> 0// will not happen
                }
            }
        }.map {
          getPoints(it[0], it[1])
        }.sum()
    }

    fun roundTwo(e: Int, i: Int): Int{
        if(i == 1){ //lose
            val test = e - 1
            if(test > 0){
                return test
            }else return 3
        }

        if(i == 2){ //draw
            return e + 3
        }

        if(i == 3){ //win
            val test = e + 1
            if(test < 4){
                return test + 6
            }else return 1 + 6
        }

        throw Exception()
    }

    fun part2(input: List<String>): Int {
        return input.map {
            it.split(" ").map {
                when(it){
                    "A" -> 1 // rock
                    "B" -> 2 // paper
                    "C" -> 3 // scissors
                    "X" -> 1 // rock
                    "Y" -> 2 // paper
                    "Z" -> 3 // scissors
                    else -> 0// will not happen
                }
            }
        }.map {
            roundTwo(it[0], it[1])
        }.sum()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 15)
    check(part2(testInput) == 12)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}

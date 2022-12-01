fun main() {
    fun getElveCals(
        input: List<String>,
    ): List<Int> {
        val snackSeparator = mutableListOf<Int>()
        input.withIndex().forEach {
            if(it.value.isEmpty()){
                snackSeparator.add(it.index)
            }
        }

        val elves = mutableListOf<Int>()

        var current = 0
        snackSeparator.forEach {
            var sum = 0
            input.subList(current, it).forEach {
                sum += it.toInt()
            }
            elves.add(sum)
            current = it + 1
        }

        var sum = 0
        val fromIndex = snackSeparator.last() + 1
        val toIndex = input.size
        input.subList(fromIndex, toIndex).forEach {
            sum += it.toInt()
        }
        elves.add(sum)

        return elves
    }

    fun part1(input: List<String>): Int {

        val elves = getElveCals(input)

        val highestCal = elves.max()

        return highestCal
    }

    fun part2(input: List<String>): Int {

        val elves = getElveCals(input)

        var calsOfTopThreeElves = 0
        elves.sortedDescending().subList(0, 3).forEach{
            calsOfTopThreeElves += it
        }

        return calsOfTopThreeElves
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 24000)
    check(part2(testInput) == 45000)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}

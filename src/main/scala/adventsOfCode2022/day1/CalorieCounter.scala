package adventsOfCode2022.day1

import adventsOfCode2022.helpers.InputReader

object CalorieCounter extends App {
  val input  = "day1_input"
  val listOfElves = parseInputToElves(InputReader.readFile(input))
  val listOfElvesWithSummedCalories = listOfElves.map(_.sum).sorted.reverse
  val maxCalories = listOfElvesWithSummedCalories.max
  println("max calories:" + maxCalories)

  println("total calories max 3: " + listOfElvesWithSummedCalories.take(3).sum)

  def parseInputToElves(input: String): Seq[Seq[Int]] = {
    val elfSeparator = "\n\n"
    input.split(elfSeparator).map(elf => {
      elf.split("\n").toSeq.map(_.toInt)
    }).toSeq
  }

}

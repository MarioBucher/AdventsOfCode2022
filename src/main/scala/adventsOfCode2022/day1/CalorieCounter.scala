package adventsOfCode2022.day1

object CalorieCounter extends App {
  val listOfElves = parseInputToElves(InputReader.readFile())
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

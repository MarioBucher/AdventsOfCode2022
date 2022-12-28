package adventsOfCode2022.day3

import adventsOfCode2022.helpers.InputReader


object RucksackReorganizer {

  @main
  def apply() = {}


  val testInput = "vJrwpWtwJgWrhcsFMMfFFhFp\njqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL\nPmmdzqPrVvPwwTWBwg\nwMqvLMZHhHMvwLHjbvcjnnSBnvTQFn\nttgJtRGJQctTZtZT\nCrZsJsPPZsGzwwsLwLmpwMDw"

  val inputFileName = "day3_input"
  val fileInput = InputReader.readFile(inputFileName)

  case class Rucksack(compartment1: String, compartment2 : String)

  println(convertInputToListOfRucksack(fileInput).map(findDuplicatesInEachRucksack(_)).map(getPriorities(_)).reduce(_+_))

  def convertInputToListOfRucksack(input: String) : Seq[Rucksack] = {
    input.linesIterator.map(line => {
      Rucksack(line.slice(0,line.length/2), line.slice(line.length/2,line.length))
    }).toSeq
  }

  def findDuplicatesInEachRucksack(ruckSack: Rucksack) : String = {
    ruckSack.compartment1.intersect(ruckSack.compartment2).toSet.mkString
  }

  lazy val priorities =  Range.inclusive('a', 'z') ++ Range.inclusive('A', 'Z')
  def getPriorities(item: String): Int = {
    priorities.indexOf(item.head)+1
  }



}

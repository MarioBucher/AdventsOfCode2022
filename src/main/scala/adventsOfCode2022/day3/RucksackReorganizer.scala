package adventsOfCode2022.day3

import adventsOfCode2022.helpers.InputReader


object RucksackReorganizer {

  case class Rucksack(compartment1: String, compartment2 : String)
  @main
  def apply() = {}


  val testInput = "vJrwpWtwJgWrhcsFMMfFFhFp\njqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL\nPmmdzqPrVvPwwTWBwg\nwMqvLMZHhHMvwLHjbvcjnnSBnvTQFn\nttgJtRGJQctTZtZT\nCrZsJsPPZsGzwwsLwLmpwMDw"

  val inputFileName = "day3_input"
  val fileInput = InputReader.readFile(inputFileName)

  val listOfRucksacks = convertInputToListOfRucksack(fileInput)
  val priorityListPart1 = listOfRucksacks.map(findDuplicatesInEachRucksack(_)).map(getPriorities(_)).reduce(_+_)
  println(s"Sum of priorities of item types in part 1 : $priorityListPart1")

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

  val badgeItems = identifyBadgeItem(listOfRucksacks)

  val priorityListPart2 = badgeItems.map(getPriorities(_)).sum
  println(s"um of priorities of item types in part 2 : $priorityListPart2")
  //part 2
  def identifyBadgeItem(listOfRucksacks : Seq[Rucksack]) : Seq[String]= {
    listOfRucksacks.grouped(3).toSeq.map(rucksacks => {
      rucksacks
        .map(rucksack => {
          (rucksack.compartment1+rucksack.compartment2).toSet.mkString
        })
        .map(p => {
          p
        })
        .reduceLeft(_.intersect(_))
    }
    )
  }

}

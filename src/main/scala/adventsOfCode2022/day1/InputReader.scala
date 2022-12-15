package adventsOfCode2022.day1

import io.Source

object InputReader {

  val filename = "day1_input"

  def readFile(): String = {
    Source.fromResource(filename).mkString
  }

}

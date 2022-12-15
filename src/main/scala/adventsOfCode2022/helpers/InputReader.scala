package adventsOfCode2022.helpers

import scala.io.Source

object InputReader {

  val filename = "day1_input"

  def readFile(): String = {
    Source.fromResource(filename).mkString
  }

}

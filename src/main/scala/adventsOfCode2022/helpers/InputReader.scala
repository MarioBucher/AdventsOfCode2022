package adventsOfCode2022.helpers

import scala.io.Source

object InputReader {

  def readFile(filename: String): String = {
    Source.fromResource(filename).mkString
  }

}

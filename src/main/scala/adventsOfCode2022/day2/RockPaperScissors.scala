package adventsOfCode2022.day2

import adventsOfCode2022.helpers.InputReader

import java.util.stream.Collectors
object RockPaperScissors extends App{
  case class Game(opponentShape : ShapeEnum, responseShape: ShapeEnum, result: GameOutcomeEnum, points: Int)

  val inputFileName= "day2_input"

  val input = InputReader.readFile(inputFileName)

  val opponentShapesMap = Map[String, ShapeEnum](
    ("A", ShapeEnum.Rock),
    ("B", ShapeEnum.Paper),
    ("C", ShapeEnum.Scissors)
  )
  val responseShapesMap = Map[String, ShapeEnum](
    ("X", ShapeEnum.Rock),
    ("Y", ShapeEnum.Paper),
    ("Z", ShapeEnum.Scissors)
  )


  val convertedInput =input.linesIterator.map(lines => {
    val shapes = lines.split(" ")
    val opponent = shapes(0)
    val response = shapes(1)
    (opponentShapesMap.get(opponent).get, responseShapesMap.get(response).get)
  }).toSeq


  val result = convertedInput.map((opponentShape,responseShape)  =>{
    val result = checkIfWin(opponentShape, responseShape)
    Game(opponentShape,
      responseShape,
      result,
      result.gamePoints + responseShape.shapeScore)
  }
  )

  val finaleScore = result.map(_.points).fold(0)(_+_)

  println(s"finale score: $finaleScore")

  def checkIfWin(opponentShape : ShapeEnum, responseShape: ShapeEnum) : GameOutcomeEnum ={
    responseShape match {
      case ShapeEnum.Rock => opponentShape match{
        
        case ShapeEnum.Rock => GameOutcomeEnum.Draw
        case ShapeEnum.Paper => GameOutcomeEnum.Lose
        case ShapeEnum.Scissors => GameOutcomeEnum.Win
      }
      case ShapeEnum.Paper => opponentShape match {

        case ShapeEnum.Rock => GameOutcomeEnum.Win
        case ShapeEnum.Paper => GameOutcomeEnum.Draw
        case ShapeEnum.Scissors => GameOutcomeEnum.Lose
      }
      case ShapeEnum.Scissors => opponentShape match {

        case ShapeEnum.Rock => GameOutcomeEnum.Lose
        case ShapeEnum.Paper => GameOutcomeEnum.Win
        case ShapeEnum.Scissors => GameOutcomeEnum.Draw
      }
    }
  }

}

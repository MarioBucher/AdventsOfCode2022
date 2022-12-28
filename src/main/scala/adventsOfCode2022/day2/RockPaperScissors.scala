package adventsOfCode2022.day2

import adventsOfCode2022.helpers.InputReader

import java.util.stream.Collectors
object RockPaperScissors extends App{
  case class Game(opponentShape : ShapeEnum, responseShape: ShapeEnum, result: GameOutcomeEnum, points: Int)
  val inputTest = "A Y \nB X\nC Z"

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

  val convertedInputPart1 = input.linesIterator.map(lines => {
    val shapes = lines.split(" ")
    val opponent = shapes(0)
    val response = shapes(1)
    (opponentShapesMap.get(opponent).get, responseShapesMap.get(response).get)
  }).toSeq

  val finaleScorePart1 = convertedInputPart1.map((opponentShape,responseShape)  =>{
    val result = GameLogic.getGameResult(opponentShape, responseShape)
    Game(opponentShape,
      responseShape,
      result,
      result.gamePoints + responseShape.shapeScore)
  }
  ).map(_.points).reduce(_+_)

  println(s"finale score part 1: $finaleScorePart1")

  // part2
  val resultMap = Map[String, GameOutcomeEnum](
    ("X", GameOutcomeEnum.Lose),
    ("Y", GameOutcomeEnum.Draw),
    ("Z", GameOutcomeEnum.Win)
  )

  val finaleScorePart2 = input.linesIterator.map(lines => {
    val shapes = lines.split(" ")
    val opponentShape = opponentShapesMap.get(shapes(0)).get
    val expectedResult = resultMap.get(shapes(1)).get
    val responseShape = GameLogic.getResponseForExpectedResult(opponentShape, expectedResult)
    Game(opponentShape, responseShape,expectedResult, responseShape.shapeScore + expectedResult.gamePoints)
  }).toSeq.map(_.points).reduce(_+_)

  println(s"finale score part 2: $finaleScorePart2")

}

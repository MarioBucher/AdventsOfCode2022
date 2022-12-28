package adventsOfCode2022.day2

import adventsOfCode2022.day2.GameLogic.rockLogic

object GameLogic {

  def rockLogic(responseShape: ShapeEnum) : GameOutcomeEnum = {
    responseShape match {
      case ShapeEnum.Rock => GameOutcomeEnum.Draw
      case ShapeEnum.Paper => GameOutcomeEnum.Win
      case ShapeEnum.Scissors => GameOutcomeEnum.Lose
    }
  }

  def paperLogic(responseShape : ShapeEnum): GameOutcomeEnum = {
    responseShape match {
      case ShapeEnum.Rock => GameOutcomeEnum.Lose
      case ShapeEnum.Paper => GameOutcomeEnum.Draw
      case ShapeEnum.Scissors => GameOutcomeEnum.Win
    }
  }

  def scissorsLogic(responseShape: ShapeEnum): GameOutcomeEnum = {
    responseShape match {
      case ShapeEnum.Rock => GameOutcomeEnum.Win
      case ShapeEnum.Paper => GameOutcomeEnum.Lose
      case ShapeEnum.Scissors => GameOutcomeEnum.Draw
    }
  }

  def getGameResult(opponentShape: ShapeEnum, responseShape: ShapeEnum): GameOutcomeEnum = {
    opponentShape match {
      case ShapeEnum.Rock => rockLogic(responseShape)
      case ShapeEnum.Paper => paperLogic(responseShape)
      case ShapeEnum.Scissors => scissorsLogic(responseShape)
    }
  }


  def getResponseForExpectedResult(opponentShape: ShapeEnum, expectedResult: GameOutcomeEnum): ShapeEnum = {
    val shapeEnumIterator =  ShapeEnum.values.iterator
    opponentShape match {
      case ShapeEnum.Rock => shapeEnumIterator.find(shape => rockLogic(shape) == expectedResult).get
      case ShapeEnum.Paper => shapeEnumIterator.find(shape => paperLogic(shape) == expectedResult).get
      case ShapeEnum.Scissors => shapeEnumIterator.find(shape => scissorsLogic(shape) == expectedResult).get
    }
  }

}

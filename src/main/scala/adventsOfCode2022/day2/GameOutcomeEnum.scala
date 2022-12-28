package adventsOfCode2022.day2

enum GameOutcomeEnum(points : Int) {
  val gamePoints = points
  
  case Win extends GameOutcomeEnum(6)
  case Lose extends GameOutcomeEnum(0)
  case Draw extends GameOutcomeEnum (3)

}
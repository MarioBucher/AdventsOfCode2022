package adventsOfCode2022.day2

enum ShapeEnum(score: Int):
  val shapeScore : Int = score

  case Rock extends ShapeEnum(1 )
  case Paper extends ShapeEnum(2)
  case Scissors extends ShapeEnum(3)


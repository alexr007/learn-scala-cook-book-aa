package aa_cookbook.x004

object NiceTransformations extends App {
  "This is the test string"
    .zipWithIndex
    // java filtering way
    .filter(t => Character.isAlphabetic(t._1))
    // scala filtering way
    //.filter{ case (c, _) => c.isLetter }
    .groupBy (t => t._1)
    .mapValues(el => el.map(_._2))
    .mapValues(_.mkString("<",".",">"))
    .toList
    .sortBy(t => t._1)
    .map(t => s"${t._1}:${t._2}")
    .mkString(", ")
    .foreach(print)
}
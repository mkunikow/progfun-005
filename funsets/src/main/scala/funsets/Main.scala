package funsets

object Main extends App {
  import FunSets._
  println(contains(singletonSet(1), 1))

  println(forall(x => x > 0 && x < 101, x => x % 2 == 0))
  println(exists(x => x > 0 && x < 101, x => x  == 2))
}

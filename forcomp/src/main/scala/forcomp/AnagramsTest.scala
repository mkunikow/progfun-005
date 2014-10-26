package forcomp
import Anagrams._

/**
 * Created by michal on 10/25/14.
 */
object Main extends App{

//  println(dictionaryByOccurrences)

//  println(getFirstKeyValueFromDictionaryByOccurrences())

//  println(dictionaryByOccurrences.filter{case (k,v) => v.length > 2})

//  println(wordOccurrences("Bush"))

  def dictionaryByOccurrencesHelper(words: List[Word] ): Map[Occurrences, List[Word]] = {
    words.map(w => (wordOccurrences(w), w)).groupBy(_._1).map{case (k,v) => (k,v.unzip._2)}
  }

//  println(dictionaryByOccurrencesHelper(List("Wawa", "awaw", "test")))


//  println(wordAnagramsHelper(List(('a',2), ('b', 2 ))))

//  println(wordAnagrams("bbaa"))

  def combinationsTest(occurrences: Occurrences): List[Occurrences] = {
    occurrences.foldRight(List[Occurrences](Nil))((value, acc) => {
      println("value: " + value + ", acc:" + acc)
      value match {
        case (char, quantity) => acc ++ (for {
          comb <- acc
          q <- 1 to quantity
//          println("comp: " + comb)
        } yield (char, q) :: comb)
      }
    })
  }


//  println(combinationsTest(List(('a', 2), ('b', 2), ('c', 1))))

//println(combinations(List(('a', 2), ('b',2))))

//println(subtract(List(('a', 2), ('b',2)), List(('a', 1), ('b',1))))
//println(subtract(List(('a', 2), ('b',2)), List(('a', 1), ('b',2))))
//println(subtract(List(('a', 2), ('b',2)), List(('a', 2), ('b',2))))


  println(sentenceAnagrams(List("Love", "I")))

}

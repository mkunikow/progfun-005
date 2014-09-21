package recfun

import java.util.NoSuchElementException

import common._

import scala.annotation.tailrec

object Main {
  def main(args: Array[String]) {
//    println("Pascal's Triangle")
//    for (row <- 0 to 10) {
//      for (col <- 0 to row)
//        print(pascal(col, row) + " ")
//      println()
//    }

    val test = "(if (zero? x) max (/ 1 x))"
    val test2 = ":-)"
    val test3 = "())("
    println(balance(test.toList))
    println(balance(test2.toList))
    println(balance(test3.toList))
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    (c, r) match {
      case (0, r) => 1
      case (c, r) if c == r => 1
      case (c, r) if c > r => throw new NoSuchElementException
      case (c, r) => pascal(c-1, r-1) + pascal(c, r - 1)
    }
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean =  {
    def changeCounter(char:Char, counter:Int): Int = {
        char match {
          case '(' => counter + 1
          case ')' => counter - 1
          case _ => counter
        }
    }
    @tailrec
    def balanceParenthes(chars: List[Char], counter:Int): Int  = {
      if (counter < 0) {
        counter
      } else {
        chars match {
          case Nil => counter
          case x :: Nil => changeCounter(x, counter)
          case x :: tail => balanceParenthes(tail, changeCounter(x, counter))
        }
      }
    }

    val ct = balanceParenthes(chars, 0)
    ct == 0
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = ???
}

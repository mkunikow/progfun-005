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

//    val test = "(if (zero? x) max (/ 1 x))"
//    val test2 = ":-)"
//    val test3 = "())("
//    println(balance(test.toList))
//    println(balance(test2.toList))
//    println(balance(test3.toList))

    println(countChange(4, List(1,2)))
    println(countChange(4, List(1,2,3)))
    println(countChange2(4, List(1,2)))
    println(countChange2(4, List(1,2,3)))
    println(countChange3(4, List(1,2)))
    println(countChange3(4, List(1,2,3)))
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

  def countChange(money: Int, coins: List[Int]): Int = {
    (money, coins) match {
      case (0, _) => 1
      case (n, _) if n < 0 => 0
      case (n, Nil) if n >=1 =>0
      case (n, head::tail) => countChange(n, tail) + countChange(n - head, coins)
    }
  }

  /**
   * Based on http://www.algorithmist.com/index.php/Coin_Change
   * @param money
   * @param coins
   * @return
   */
  def countChange2(money: Int, coins: List[Int]): Int = {
    def count(n: Int, m: Int ): Int = {
      if (n == 0) 1
      else if (n < 0) 0
      else if (m <= 0 && n >= 1) 0
      else count( n, m - 1 ) + count( n - coins(m -1), m )
    }
    count(money, coins.length)
  }

  def countChange3(money: Int, coins: List[Int]): Int = {

    if (money == 0) 1
    else if (money < 0) 0
    else if (coins.isEmpty && money >= 1) 0
    else countChange3(money, coins.tail) + countChange3(money - coins.head, coins)

  }
}

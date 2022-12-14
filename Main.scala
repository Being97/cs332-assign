package recfun
import common._
import scala.annotation.tailrec

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if (c == 0 || c == r) 1
    else pascal(c-1, r-1) * r / c
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    @tailrec
    def loop(chars: List[Char], OpenedParentheses: Int): Boolean = {
      if(chars.isEmpty) OpenedParentheses == 0
      else if (chars.head == ')' && OpenedParentheses < 1) false
      else {
        val h = chars.head
        val numOpened =
          if (h == '(') OpenedParentheses + 1
          else if (h == ')') OpenedParentheses - 1
          else OpenedParentheses
        loop(chars.tail, numOpened)
        }
      }
    loop(chars, 0)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    if (money == 0) 1
    else if (money < 0 || coins.isEmpty) 0
    else {
      countChange(money - coins.head, coins) + countChange(money, coins.tail)
    }
  }
}
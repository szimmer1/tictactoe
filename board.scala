package board

class Board(size: Int) {
  val _size = size
  var board = Array.ofDim[Int](size,size)

  def getCell(row: Int, col: Int) = board(row)(col)
  def setCell(row: Int, col: Int, value: Int) = board(row)(col) = value

  def winner(): Int = {
    // check rows, then check columns, then check diagonals
    //val checkRows = Array((0,0),(0,1),(0,2)...), Array((1,0),(1,1),(1,2))...
    //val checkCols = Array((0,0),(1,0),(2,0)...), Array((0,1),(1,1),(2,1))...
    //val
    var found: Int = 0
    found
    //while (found == 0)
  }

  override def toString(): String = {
    headerStr() + separatorRowStr() +
    board.zipWithIndex.map { case (row: Array[Int], i: Int) =>
      rowStr(row, i) + separatorRowStr()
    }.mkString("")
  }

  protected

  /*
    toString() helpers
   */

  def headerStr(): String = "   " + (1 to _size).mkString(" ") + " \n"
  def separatorRowStr(): String = "  " + ("--" * (_size)) + "-\n"
  def rowStr(row: Array[Int], i: Int): String = {
    (i + 1) + " |" + row
      .map(cell => { if (cell == 1) 'X' else if (cell == -1) 'O' else ' ' })
      .mkString("|") + "|\n"
  }
}
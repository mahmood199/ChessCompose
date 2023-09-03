package game.set.piece

import game.board.Board
import game.board.Cell
import game.set.Color

interface Piece {

    val color: Color

    fun getPossibleTargetCells(board: Board, currentCell: Cell): List<Cell>

}
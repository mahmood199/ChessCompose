package game.piece

import game.board.Board
import game.board.Cell

interface Piece {

    val color: Color

    fun getPossibleTargetCells(board: Board, currentCell: Cell): List<Cell>

}
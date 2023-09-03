package game.set.piece

import game.board.Board
import game.board.Cell
import game.set.Color

class Pawn(override val color: Color) : Piece {

    override fun getPossibleTargetCells(
        board: Board,
        currentCell: Cell
    ): List<Cell> {
        TODO("Not yet implemented")
    }

}
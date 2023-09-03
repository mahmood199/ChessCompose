package game.piece

import game.board.Board
import game.board.Cell

class Knight(override val color: Color) : Piece {

    override fun getPossibleTargetCells(
        board: Board,
        currentCell: Cell
    ): List<Cell> {
        TODO("Not yet implemented")
    }

}

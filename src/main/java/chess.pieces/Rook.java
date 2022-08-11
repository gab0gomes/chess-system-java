package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece {
    public Rook(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "R";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] availableMoves = new boolean[this.getBoard().getRows()][this.getBoard().getColumns()];

        Position pos = new Position(0, 0);

        // above
        pos.setValues(this.position.getRow() - 1, this.position.getColumn());
        while (this.getBoard().positionExists(pos) && !this.getBoard().thereIsAPiece(pos)) {
            availableMoves[pos.getRow()][pos.getColumn()] = true;
            pos.setRow(pos.getRow() - 1);
        }

        if (this.getBoard().positionExists(pos) && this.isThereOpponentPiece(pos)) {
            availableMoves[pos.getRow()][pos.getColumn()] = true;
        }

        // left
        pos.setValues(this.position.getRow(), this.position.getColumn() - 1);
        while (this.getBoard().positionExists(pos) && !this.getBoard().thereIsAPiece(pos)) {
            availableMoves[pos.getRow()][pos.getColumn()] = true;
            pos.setColumn(pos.getColumn() - 1);
        }

        if (this.getBoard().positionExists(pos) && this.isThereOpponentPiece(pos)) {
            availableMoves[pos.getRow()][pos.getColumn()] = true;
        }

        // right
        pos.setValues(this.position.getRow(), this.position.getColumn() + 1);
        while (this.getBoard().positionExists(pos) && !this.getBoard().thereIsAPiece(pos)) {
            availableMoves[pos.getRow()][pos.getColumn()] = true;
            pos.setColumn(pos.getColumn() + 1);
        }

        if (this.getBoard().positionExists(pos) && this.isThereOpponentPiece(pos)) {
            availableMoves[pos.getRow()][pos.getColumn()] = true;
        }

        // below
        pos.setValues(this.position.getRow() + 1, this.position.getColumn());
        while (this.getBoard().positionExists(pos) && !this.getBoard().thereIsAPiece(pos)) {
            availableMoves[pos.getRow()][pos.getColumn()] = true;
            pos.setRow(pos.getRow() + 1);
        }

        if (this.getBoard().positionExists(pos) && this.isThereOpponentPiece(pos)) {
            availableMoves[pos.getRow()][pos.getColumn()] = true;
        }

        return availableMoves;
    }
}

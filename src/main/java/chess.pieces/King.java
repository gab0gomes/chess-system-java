package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {
    public King(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "K";
    }

    private boolean canMove(Position position) {
        ChessPiece piece = (ChessPiece) this.getBoard().piece(position);
        return piece == null || piece.getColor() != this.getColor();
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] matrix = new boolean[this.getBoard().getRows()][this.getBoard().getColumns()];

        Position newPosition = new Position(0,0);
        //above
        newPosition.setValues(this.position.getRow() - 1, this.position.getColumn());
        if (this.getBoard().positionExists(newPosition) && this.canMove(newPosition)) {
            matrix[newPosition.getRow()][newPosition.getColumn()] = true;
        }

        //below
        newPosition.setValues(this.position.getRow() + 1, this.position.getColumn());
        if (this.getBoard().positionExists(newPosition) && this.canMove(newPosition)) {
            matrix[newPosition.getRow()][newPosition.getColumn()] = true;
        }

        //left
        newPosition.setValues(this.position.getRow(), this.position.getColumn() - 1);
        if (this.getBoard().positionExists(newPosition) && this.canMove(newPosition)) {
            matrix[newPosition.getRow()][newPosition.getColumn()] = true;
        }

        //right
        newPosition.setValues(this.position.getRow(), this.position.getColumn() + 1);
        if (this.getBoard().positionExists(newPosition) && this.canMove(newPosition)) {
            matrix[newPosition.getRow()][newPosition.getColumn()] = true;
        }

        //nw
        newPosition.setValues(this.position.getRow() - 1, this.position.getColumn() - 1);
        if (this.getBoard().positionExists(newPosition) && this.canMove(newPosition)) {
            matrix[newPosition.getRow()][newPosition.getColumn()] = true;
        }

        //ne
        newPosition.setValues(this.position.getRow() - 1, this.position.getColumn() + 1);
        if (this.getBoard().positionExists(newPosition) && this.canMove(newPosition)) {
            matrix[newPosition.getRow()][newPosition.getColumn()] = true;
        }

        //sw
        newPosition.setValues(this.position.getRow() + 1, this.position.getColumn() - 1);
        if (this.getBoard().positionExists(newPosition) && this.canMove(newPosition)) {
            matrix[newPosition.getRow()][newPosition.getColumn()] = true;
        }

        //se
        newPosition.setValues(this.position.getRow() + 1, this.position.getColumn() + 1);
        if (this.getBoard().positionExists(newPosition) && this.canMove(newPosition)) {
            matrix[newPosition.getRow()][newPosition.getColumn()] = true;
        }

        return matrix;
    }
}

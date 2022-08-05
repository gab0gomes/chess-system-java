package boardgame;

import java.util.Arrays;

public abstract class Piece {
    protected Position position;
    private Board board;

    public Piece(Board board) {
        this.position = null;
        this.board = board;
    }

    protected Board getBoard() {
        return board;
    }

    public abstract boolean[][] possibleMoves();

    public boolean possibleMove(Position position) {
        return this.possibleMoves()[position.getRow()][position.getColumn()];
    }

    public boolean isThereAnyPossibleMove() {
        boolean[][] matrix = this.possibleMoves();
        for (boolean[] row : matrix) {
            for (boolean column : row) {
                if (column) {
                    return true;
                }
            }
        }
        return false;
    }
}

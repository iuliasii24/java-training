package board;

import pieces.Piece;

public abstract class Move {
    final Board board;
    final Piece MovedPiece;
    final int DestCoord;

    private Move(final Board board, final Piece MovedPiece, final int DestCoord)
    {
        this.board=board;
        this.MovedPiece=MovedPiece;
        this.DestCoord=DestCoord;
    }

    public static final class MMove extends Move{
        public MMove(final Board board, final Piece MovedPiece, final int DestCoord) {
            super(board, MovedPiece, DestCoord);
        }
    }

    public static final class AttackMove extends Move{
        final Piece AttackedPiece;
        public AttackMove(final Board board, final Piece MovedPiece, final int DestCoord, final Piece AttackedPiece){
            super(board, MovedPiece, DestCoord);
            this.AttackedPiece=AttackedPiece;
        }
    }
}

package pieces;
import board.Board;
import board.Move;
import java.util.Collection;
import java.util.List;

public abstract class Piece {
    protected final int Position;
    protected final Alliance A;
    protected final boolean FirstMove;

    Piece(final int Position, final Alliance A)
    {
        this.A=A;
        this.Position=Position;
        this.FirstMove=false;
    }

    public int getPosition(){
        return this.Position;
    }
    public Alliance getAlliance(){
        return this.A;
    }
    public boolean FirstMove(){
        return this.FirstMove;
    }
    public abstract Collection<Move> NrLegalMoves(final Board board);

}

package pieces;

import board.Board;
import board.BoardUtils;
import board.Move;
import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Pawn extends Piece{
    private final static int[] move_coord={8};
    public Pawn(final int Position, final Alliance A){
        super(Position,A);
    }
    @Override
    public Collection<Move> NrLegalMoves(Board board){
        final List<Move> legalM=new ArrayList<>();
        for(final int current:move_coord){
            int candidateDestCoord=this.Position+(this.getAlliance().getDirection())+current;
            if(!BoardUtils.ValidTCoord(current)){
                continue;
            }
            if(current==8&&!board.getTile(candidateDestCoord).isOccupied()){
                legalM.add(new Move.MMove(board,this,candidateDestCoord));
            }
            else
                if(current==16&&this.FirstMove()&&
                        (BoardUtils.SECOND_ROW[this.Position]&&this.getAlliance().isB())||
                        (BoardUtils.SEVENTH_ROW[this.Position]&&this.getAlliance().isW())){
                                final int behindDestCoord=this.Position+this.getAlliance().getDirection()+8;
                                if(!board.getTile(behindDestCoord).isOccupied()&&!board.getTile(candidateDestCoord).isOccupied()){
                                    legalM.add(new Move.MMove(board,this,candidateDestCoord));

                                }
                                else
                                    if(current==7&&!(BoardUtils.EIGHTH_COLUMN[this.Position]&&this.getAlliance().isW())||
                                            (BoardUtils.FIRST_COLUMN[this.Position]&&this.getAlliance().isB())){
                                            if(board.getTile(candidateDestCoord).isOccupied() ){
                                                final Piece pieceC=board.getTile(candidateDestCoord).getPiece();
                                                if(this.getAlliance()!=pieceC.getAlliance())
                                                {
                                                    legalM.add(new Move.MMove(board,this,candidateDestCoord));
                                                }
                                            }
                                    }
                                    else
                                        if(current==9&&!(BoardUtils.FIRST_COLUMN[this.Position]&&this.getAlliance().isW())||
                                                (BoardUtils.EIGHTH_COLUMN[this.Position]&&this.getAlliance().isB())){
                                            if(board.getTile(candidateDestCoord).isOccupied() ){
                                                final Piece pieceC=board.getTile(candidateDestCoord).getPiece();
                                                if(this.getAlliance()!=pieceC.getAlliance())
                                                {
                                                    legalM.add(new Move.MMove(board,this,candidateDestCoord));
                                                }
                                            }
                                        }
                }
        }
        return ImmutableList.copyOf(legalM);
    }
}

package board;
import com.google.common.collect.ImmutableList;
import pieces.Alliance;
import pieces.Pawn;
import pieces.Piece;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class Board {
    private final List<Tile> game;
    private final Collection<Piece> whiteP;
    private final Collection<Piece> blackP;
    private Board(Build builder)
    {
        this.game=createGame(builder);
        this.whiteP=NrActivePieces(this.game,Alliance.White);
        this.blackP=NrActivePieces(this.game,Alliance.Black);
    }

    private Collection<Piece> NrActivePieces(List<Tile> game, Alliance A) {
        final List<Piece> active=new ArrayList<>();
        for(final Tile tile:game) {
            if (tile.isOccupied()) {
                final Piece piece = tile.getPiece();
                if (piece.getAlliance() == A) {
                    active.add(piece);
                }
            }
        }
        return ImmutableList.copyOf(active);
    }

    private static List<Tile>createGame(final Build builder){
        final Tile[] tiles=new Tile[BoardUtils.NrTiles];
        for(int i=0;i<BoardUtils.NrTiles;i++) {
            tiles[i] = Tile.createT(i, builder.boardConfig.get(i));
        }
        return ImmutableList.copyOf(tiles);
    }
    public static Board createNewBoard(){
        final Build b=new Build();
        b.setPiece(new Pawn(48, Alliance.White));
        b.setPiece(new Pawn(49, Alliance.White));
        b.setPiece(new Pawn(50, Alliance.White));
        b.setPiece(new Pawn(51, Alliance.White));
        b.setPiece(new Pawn(52, Alliance.White));
        b.setPiece(new Pawn(53, Alliance.White));
        b.setPiece(new Pawn(54, Alliance.White));
        b.setPiece(new Pawn(55, Alliance.White));

        b.setPiece(new Pawn(8, Alliance.Black));
        b.setPiece(new Pawn(9, Alliance.Black));
        b.setPiece(new Pawn(10, Alliance.Black));
        b.setPiece(new Pawn(11, Alliance.Black));
        b.setPiece(new Pawn(12, Alliance.Black));
        b.setPiece(new Pawn(13, Alliance.Black));
        b.setPiece(new Pawn(14, Alliance.Black));
        b.setPiece(new Pawn(15, Alliance.Black));

        b.setMove(Alliance.White);
        //build the board
        return b.build();
    }
    public Tile getTile(final int TileCoord){
        return game.get(TileCoord);
    }
    public static class Build{
        Map<Integer, Piece> boardConfig;
        Alliance nextMove;
        public Build(){
        }
        public Build setPiece(final Piece piece){
            this.boardConfig.put(piece.getPosition(), piece);
            return this;
        }
        public Build setMove(final Alliance nextMove){
            this.nextMove=nextMove;
            return this;
        }
        public Board build(){
            return new Board(this);
        }
    }
}

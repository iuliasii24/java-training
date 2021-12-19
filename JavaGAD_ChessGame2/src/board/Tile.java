package board;
import com.google.common.collect.ImmutableMap;
import pieces.Piece;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public abstract class Tile {
    protected final int TileCoord;
    private static final Map<Integer, Empty> EMPTY=createAllEmptyTiles();

    private static Map<Integer, Empty> createAllEmptyTiles() {
        final Map<Integer, Empty> emptyTM=new HashMap<>();
        for(int i=0;i<=63;i++){
            emptyTM.put(i, new Empty(i));
        }

        return ImmutableMap.copyOf(emptyTM);
    }

    public static Tile createT(final int TileCoord, final Piece piece)
    {
        return piece!=null ? new Occupied(TileCoord, piece) : EMPTY.get(TileCoord);
    }

    //constructor
    private Tile(int TileCoord){
        this.TileCoord=TileCoord;
    }

    //verifica daca spatiul/patratul este ocupat
    public abstract boolean isOccupied();

    public abstract Piece getPiece();

    public static final class Empty extends Tile{
        //constructor
        Empty(final int coord)
        {
            super(coord);
        }
        @Override
        public boolean isOccupied()
        {
            return false;
        }
        @Override
        public Piece getPiece()
        {
            return null;
        }
    }

    public static final class Occupied extends Tile{
        private final Piece PieceOnTile;
        Occupied(int TileCoord, Piece PieceOnTile){
            super(TileCoord);
            this.PieceOnTile=PieceOnTile;
        }
        @Override
        public boolean isOccupied()
        {
            return true;
        }
        @Override
        public Piece getPiece()
        {
            return this.PieceOnTile;
        }

    }
}

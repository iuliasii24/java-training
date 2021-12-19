package board;

public class BoardUtils {
    public static final boolean[] FIRST_COLUMN=initColumn(0);

    private static boolean[] initColumn(int c) {
        final boolean[] column=new boolean[64];
        while(c<64)
        {
            column[c]=true;
            c+=8;
        }
        return column;
    }

    public static final boolean[] SECOND_COLUMN=initColumn(1);
    public static final boolean[] SEVENTH_COLUMN=initColumn(6);
    public static final boolean[] EIGHTH_COLUMN=initColumn(7);
    public static final boolean[] SECOND_ROW=null;
    public static final boolean[] SEVENTH_ROW=null;

    public static final int NrTiles=64;
    public static final int NrTilesPerRow=8;

    private BoardUtils()
    {
        throw new RuntimeException(" ");
    }
    public static boolean ValidTCoord(int coord)
    {
        return coord>=0 && coord<=63;
    }
}

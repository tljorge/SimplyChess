
package simplychess;

import pieces.Piece;

/**
 *
 * @author Tyler Jorgensen
 */

//invisible object holding all tile values
public class Tile {
    //class attributes
    private Piece p;
    public int pieceVal;   // 0 = empty
                           // 1 = pawn
                           // 2 = rook
                           // 3 = knight
                           // 4 = bishop
                           // 5 = queen
                           // 6 = king
    
    private final int x;
    private final int y;
    boolean moveable = false; //tiles should be moveable until piece is pressed        

    
    //Constructor for no piece
    public Tile(int x, int y){
        this.x = x; this.y = y;  
    }

        
    //sets the piece on the tile
    public void setPiece(Piece p){
        this.p = p;
    }
    
    //sets the piece value for 
    public void setPieceVal(int val){
        this.pieceVal = val;
    }

    //returns the value of the piece on this tile
    public int getPieceVal(){
        return this.pieceVal;
    }
    
    //returns the piece on this tile
    public Piece getPiece(){
        return this.p;
    }
    
    
    public int getXCoord(){
        return this.x;
    }
    
    public int getYCoord(){
        return this.y;
    }
}

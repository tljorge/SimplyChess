package pieces;

import javafx.scene.control.ToggleButton;

/**
 *
 * @author Tyler Jorgensen
 */
public abstract class Piece extends ToggleButton{
    String resource; //path for piece
    int xPos; //0-7, tile position on board
    int yPos; 
    final int pieceVal;
    private final String NORMAL = "-fx-background-color: transparent";
    
    public Piece(int val, int x, int y){ 
        this.xPos = x;
        this.yPos = y;
        this.pieceVal = val;
        setStyle(NORMAL);
    }
}

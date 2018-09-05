/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pieces;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author Tyler Jorgensen
 */
public class Knight extends Piece {
    
    public Knight(int val, int x, int y) {
        super(val, x, y);
        
        switch (this.pieceVal) {
            case 3:
                setGraphic(new ImageView(new Image(getClass().getResource("/resources/knight_white.png").toString())));
                break;
            case -3:
                setGraphic(new ImageView(new Image(getClass().getResource("/resources/knight_black.png").toString())));
                break;
            default:
                System.out.println("no resource");
                break;
        }
    }
    
}

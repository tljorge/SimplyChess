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
public class Bishop extends Piece {
    
    public Bishop(int val, int x, int y) {
        super(val, x, y);
        switch (this.pieceVal) {
            case 4:
                setGraphic(new ImageView(new Image(getClass().getResource("/resources/bishop_white.png").toString())));
                break;
            case -4:
                setGraphic(new ImageView(new Image(getClass().getResource("/resources/bishop_black.png").toString())));
                break;
            default:
                System.out.println("no resource");
                break;
        }
    }
    
}

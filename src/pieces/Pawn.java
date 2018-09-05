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
public class Pawn extends Piece {
    public Pawn(int v, int x, int y) {
        super(v, x, y);
        
        switch (this.pieceVal) {
            case 1:
                setGraphic(new ImageView(new Image(getClass().getResource("/resources/pawn_white.png").toString())));
                break;
            case -1:
                setGraphic(new ImageView(new Image(getClass().getResource("/resources/pawn_black.png").toString())));
                break;
            default:
                System.out.println("no resource");
                break;
        }
    } 
}

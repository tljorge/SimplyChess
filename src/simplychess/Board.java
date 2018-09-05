
package simplychess;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import pieces.*;


public class Board {

    private final int BOARD_START_X = 64; private final int BOARD_END_X = 64*9;
    private final int BOARD_START_Y = 64; private final int BOARD_END_Y = 64*9;
    private final int TILE_SIZE = 64;   //length of tile
    public Tile[][] board; //holds board of tiles
    public int[][] tileValues; //holds the initial starting values of board
    private final int PAD_X = -10 ; //padding to center the pieces
    private final int PAD_Y = -5;
    
    //constructs 8x8 board object, contains 2d array of tiles
    public Board(){
        this.board = new Tile[8][8];     //Tile container
        this.tileValues = new int[][]{{-2,-3,-4,-5,-6,-4,-3,-2}, //Initial config of board
                                      {-1,-1,-1,-1,-1,-1,-1,-1},
                                      { 0, 0, 0, 0, 0, 0, 0, 0},
                                      { 0, 0, 0, 0, 0, 0, 0, 0},
                                      { 0, 0, 0, 0, 0, 0, 0, 0},
                                      { 0, 0, 0, 0, 0, 0, 0, 0},
                                      { 1, 1, 1, 1, 1, 1, 1, 1},
                                      { 2, 3, 4, 5, 6, 4, 3, 2}};
        
    }
    
    //creating all the tiles for the board and assigning piece values and pieces
    public void initBoard(Pane pane) {
        drawBoard(pane);

        
        for (int x = BOARD_START_Y, column = 0; x < BOARD_END_Y; x += TILE_SIZE, column++) {
            System.out.println("");
            for (int y = BOARD_START_X, row = 0; y < BOARD_END_X; y += TILE_SIZE, row++) {
                System.out.print("X : "+x+ ", Y "+ y + " | ");
                Tile t = new Tile(x, y);
                board[row][column] = t;
                t.setPieceVal(tileValues[row][column]);

                if (t.pieceVal == 1) {
                    Piece p = new Pawn(1, x, y);
                    t.setPiece(p);
                    p.setLayoutX(x + PAD_X);
                    p.setLayoutY(y + PAD_Y);
                    pane.getChildren().add(p);
                } else if (t.pieceVal == -1) {
                    Piece p = new Pawn(-1, x, y);
                    t.setPiece(p);
                    p.setLayoutX(x + PAD_X);
                    p.setLayoutY(y + PAD_Y);
                    pane.getChildren().add(p);
                } else if (t.pieceVal == 2) {
                    Piece p = new Rook(2, x, y);
                    t.setPiece(p);
                    p.setLayoutX(x + PAD_X);
                    p.setLayoutY(y + PAD_Y);
                    pane.getChildren().add(p);
                } else if (t.pieceVal == -2) {
                    Piece p = new Rook(-2, x, y);
                    t.setPiece(p);
                    p.setLayoutX(x + PAD_X);
                    p.setLayoutY(y + PAD_Y);
                    pane.getChildren().add(p);
                } else if (t.pieceVal == 2) {
                    Piece p = new Rook(2, x, y);
                    t.setPiece(p);
                    p.setLayoutX(x + PAD_X);
                    p.setLayoutY(y + PAD_Y);
                    pane.getChildren().add(p);
                } else if (t.pieceVal == 3) {
                    Piece p = new Knight(3, x, y);
                    t.setPiece(p);
                    p.setLayoutX(x + PAD_X);
                    p.setLayoutY(y + PAD_Y);
                    pane.getChildren().add(p);
                }
                else if (t.pieceVal == -3) {
                    Piece p = new Knight(-3, x, y);
                    t.setPiece(p);
                    p.setLayoutX(x + PAD_X);
                    p.setLayoutY(y + PAD_Y);
                    pane.getChildren().add(p);
                } else if (t.pieceVal == 4) {
                    Piece p = new Bishop(4, x, y);
                    t.setPiece(p);
                    p.setLayoutX(x + PAD_X);
                    p.setLayoutY(y + PAD_Y);
                    pane.getChildren().add(p);
                } else if (t.pieceVal == -4) {
                    Piece p = new Bishop(-4, x, y);
                    t.setPiece(p);
                    p.setLayoutX(x + PAD_X);
                    p.setLayoutY(y + PAD_Y);
                    pane.getChildren().add(p);
                } else if (t.pieceVal == 5) {
                    Piece p = new Queen(5, x, y);
                    t.setPiece(p);
                    p.setLayoutX(x + PAD_X);
                    p.setLayoutY(y + PAD_Y);
                    pane.getChildren().add(p);
                } else if (t.pieceVal == -5) {
                    Piece p = new Queen(-5, x, y);
                    t.setPiece(p);
                    p.setLayoutX(x + PAD_X);
                    p.setLayoutY(y + PAD_Y);
                    pane.getChildren().add(p);
                } else if (t.pieceVal == 6) {
                    Piece p = new King(6, x, y);
                    t.setPiece(p);
                    p.setLayoutX(x + PAD_X);
                    p.setLayoutY(y + PAD_Y);
                    pane.getChildren().add(p);
                } else if (t.pieceVal == -6) {
                    Piece p = new King(-6, x, y);
                    t.setPiece(p);
                    p.setLayoutX(x + PAD_X);
                    p.setLayoutY(y + PAD_Y);
                    pane.getChildren().add(p);
                }
            }
            
           
        }
    }
    
    //draws the board with the initial configuration of the game
    private void drawBoard(Pane p){
        for (int x = BOARD_START_X,column=0;x<BOARD_END_Y;x+=TILE_SIZE, column++){
            for (int y = BOARD_START_Y,row=0;y<BOARD_END_X;y+=TILE_SIZE,row++){
                Rectangle r = new Rectangle();
                r.setWidth(64);   r.setLayoutX(x);
                r.setHeight(64);  r.setLayoutY(y);
                
                //coloring rectangles
                boolean evenRow = row % 2 == 0;
                boolean evenColumn = column % 2 == 0;
                if (evenRow == evenColumn){
                    r.setFill(Color.BURLYWOOD);
                } else {
                    r.setFill(Color.PERU);
                }
                
                p.getChildren().add(r);
                
            }
        }
    }
    
    
    public void move(int x,int y){
    }
    //takes the update configuration of the board and re-draws the pieces to correct position
    
    public Tile getTile(int x, int y){
        return board[x][y];
    }
    
}

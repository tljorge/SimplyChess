
package simplychess;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import pieces.Bishop;
import pieces.King;
import pieces.Knight;
import pieces.Pawn;
import pieces.Piece;
import pieces.Queen;
import pieces.Rook;

/**
 *
 * @author tyler.jorgensen
 */
public class SimplyChess extends Application {
    
    //Stage/scene dimensions
    final int WIDTH = 800;
    final int HEIGHT = 640;
    final int CENTER_X = WIDTH/2;
    final int CENTER_Y = HEIGHT/2;
    
    final int PAD_X = -10;
    final int PAD_Y = -5;
    
    //Menu Buttons
    ImageButton start = new ImageButton("/resources/play.png");
    ImageButton settings = new ImageButton("/resources/settings.png");
    ImageButton quit = new ImageButton("/resources/quit.png");
    
    //Settings buttons
    ImageButton backToMenuFromSettings = new ImageButton("/resources/back.png");
    
    //Settings labels
    Label timeLabel = new Label("Turn Length:");
    
    //Settings fields
    TextField timeField = new TextField();
    
    //Game buttons
    ImageButton backToMenuFromGame = new ImageButton("/resources/back.png");
    
    //Game labels
    Label gameStatsLabel = new Label("Game Stats");
    Label movesLabel = new Label("Moves\t| 0");
    Label opponentLabel = new Label("Computer");
    Label oppTimeLabel = new Label("Time \t| 60:00");
    Label oppPiecesLabel = new Label("Pieces\t| 16");
    Label oppScoreLabel = new Label("Score\t| 0");
    Label playerLabel = new Label("The Brogrammers");
    Label plyTimeLabel = new Label("Time \t| 60:00");
    Label plyPiecesLabel = new Label("Pieces\t| 16");
    Label plyScoreLabel = new Label("Score\t| 0");
    
    //Pane for all scenes
    Pane menuRoot = new Pane();
    Pane gameRoot = new Pane();
    Pane settingsRoot = new Pane();
    
    //Scenes for each view
    Scene menuScene = new Scene(menuRoot,WIDTH,HEIGHT);
    Scene settingsScene = new Scene(settingsRoot,WIDTH,HEIGHT);
    Scene gameScene = new Scene(gameRoot,WIDTH,HEIGHT);
    
    //Board game object
    Board b = new Board();
    
    //Backgrounds for different scenes
    ImageView gameBackground = new ImageView();
    ImageView menuBackground = new ImageView();
    
    @Override
    public void start(Stage primaryStage) {
        int fontSize = 16;
        String fontFamily = "Arial Narrow";
        
        //Button events -> Menu
        start.setOnAction(e -> primaryStage.setScene(gameScene));
        settings.setOnAction(e -> primaryStage.setScene(settingsScene));
        quit.setOnAction(e -> primaryStage.close());
        
        //Button events -> Settings
        backToMenuFromSettings.setOnAction(e -> primaryStage.setScene(menuScene));
        
        //Button events -> Game
        backToMenuFromGame.setOnAction(e -> primaryStage.setScene(menuScene));
       
        //Button layout -> Menu
        start.setLayoutX(CENTER_X+100);start.setLayoutY(CENTER_Y);
        settings.setLayoutX(CENTER_X+100);settings.setLayoutY(CENTER_Y+90);
        quit.setLayoutX(CENTER_X+100);quit.setLayoutY(CENTER_Y+180);
        
        //Button layout -> Settings
        backToMenuFromSettings.setLayoutX(WIDTH-150);
        backToMenuFromSettings.setLayoutY(HEIGHT-75);
        
        //Label layout -> Settings
        timeLabel.setLayoutX(40);
        timeLabel.setLayoutY(40);
        timeLabel.setStyle("-fx-font-weight: bold");
        timeLabel.setFont(Font.font(fontFamily, fontSize));
        
        //Field layout -> Settings
        timeField.setLayoutX(160);
        timeField.setLayoutY(37);
        timeField.setStyle("-fx-font-weight: bold");
        timeField.setFont(Font.font(fontFamily, fontSize));
        
        //Button layout -> Game
        backToMenuFromGame.setLayoutX(WIDTH-150);
        backToMenuFromGame.setLayoutY(HEIGHT-75);
        
        //Label layout -> Game
        int gSideBarCoord = 665;
        int gNextLineSpacing = 30;
        int gStartSpacing = 30;
        
        gameStatsLabel.setLayoutX(gSideBarCoord);
        gameStatsLabel.setLayoutY(gStartSpacing);
        gameStatsLabel.setStyle("-fx-font-weight: bold");
        gameStatsLabel.setFont(Font.font(fontFamily, fontSize));
        movesLabel.setLayoutX(gSideBarCoord);
        movesLabel.setLayoutY(gStartSpacing+gNextLineSpacing);
        movesLabel.setStyle("-fx-font-weight: bold");
        movesLabel.setFont(Font.font(fontFamily, fontSize));
        opponentLabel.setLayoutX(gSideBarCoord);
        opponentLabel.setLayoutY(gStartSpacing+gNextLineSpacing*3);
        opponentLabel.setStyle("-fx-font-weight: bold");
        opponentLabel.setFont(Font.font(fontFamily, fontSize));
        oppTimeLabel.setLayoutX(gSideBarCoord);
        oppTimeLabel.setLayoutY(gStartSpacing+gNextLineSpacing*4);
        oppTimeLabel.setStyle("-fx-font-weight: bold");
        oppTimeLabel.setFont(Font.font(fontFamily, fontSize));
        oppPiecesLabel.setLayoutX(gSideBarCoord);
        oppPiecesLabel.setLayoutY(gStartSpacing+gNextLineSpacing*5);
        oppPiecesLabel.setStyle("-fx-font-weight: bold");
        oppPiecesLabel.setFont(Font.font(fontFamily, fontSize));
        oppScoreLabel.setLayoutX(gSideBarCoord);
        oppScoreLabel.setLayoutY(gStartSpacing+gNextLineSpacing*6);
        oppScoreLabel.setStyle("-fx-font-weight: bold");
        oppScoreLabel.setFont(Font.font(fontFamily, fontSize));
        playerLabel.setLayoutX(gSideBarCoord);
        playerLabel.setLayoutY(gStartSpacing+gNextLineSpacing*8);
        playerLabel.setStyle("-fx-font-weight: bold");
        playerLabel.setFont(Font.font(fontFamily, fontSize));
        plyTimeLabel.setLayoutX(gSideBarCoord);
        plyTimeLabel.setLayoutY(gStartSpacing+gNextLineSpacing*9);
        plyTimeLabel.setStyle("-fx-font-weight: bold");
        plyTimeLabel.setFont(Font.font(fontFamily, fontSize));
        plyPiecesLabel.setLayoutX(gSideBarCoord);
        plyPiecesLabel.setLayoutY(gStartSpacing+gNextLineSpacing*10);
        plyPiecesLabel.setStyle("-fx-font-weight: bold");
        plyPiecesLabel.setFont(Font.font(fontFamily, fontSize));
        plyScoreLabel.setLayoutX(gSideBarCoord);
        plyScoreLabel.setLayoutY(gStartSpacing+gNextLineSpacing*11);
        plyScoreLabel.setStyle("-fx-font-weight: bold");
        plyScoreLabel.setFont(Font.font(fontFamily, fontSize));
        
        //Background image loading
        try{
            gameBackground.setImage(new Image
                    (getClass().getResource("/resources/game_back.PNG").toString()));
            menuBackground.setImage(new Image
                    (getClass().getResource("/resources/menu_back.PNG").toString()));
        }catch(Exception e){
            System.out.println("Bad background image path");
        }
        
        //Adding notes to panes
        menuRoot.getChildren().addAll(menuBackground,start,settings,quit);
        gameRoot.getChildren().addAll(gameBackground,backToMenuFromGame,gameStatsLabel,movesLabel,opponentLabel,
        		oppTimeLabel,oppPiecesLabel,oppScoreLabel,playerLabel,plyTimeLabel,plyPiecesLabel,plyScoreLabel);
        settingsRoot.getChildren().addAll(backToMenuFromSettings,timeLabel,timeField);
        
        //Board initilization/drawing
        b.initBoard(gameRoot);
        update(b,gameRoot);
        
        
        primaryStage.setResizable(false);
        primaryStage.show();
        primaryStage.setTitle("Simply Chess");
        primaryStage.setScene(menuScene);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public void update(Board b,Pane pane){
        for (int x=0;x<8;x++){
            System.out.println("");
            for (int y=0;y<8;y++){
                System.out.print(b.getTile(x,y).getPieceVal()+", ");
                switch (b.getTile(x, y).getPieceVal()) {
                    case 1:
                        {
                            Piece p = new Pawn(1, b.getTile(x, y).getXCoord(), b.getTile(x, y).getYCoord());
                            b.getTile(x, y).setPiece(p);
                            p.setLayoutX(b.getTile(x, y).getXCoord() + PAD_X);
                            p.setLayoutY(b.getTile(x, y).getYCoord() + PAD_Y);
                            pane.getChildren().add(p);
                            break;
                        }
                    case -1:
                        {
                            Piece p = new Pawn(-1,b.getTile(x, y).getXCoord(), b.getTile(x, y).getYCoord());
                            b.getTile(x, y).setPiece(p);
                            p.setLayoutX(b.getTile(x, y).getXCoord() + PAD_X);
                            p.setLayoutY(b.getTile(x, y).getYCoord() + PAD_Y);
                            pane.getChildren().add(p);
                            break;
                        }
                    case 2:
                        {
                            Piece p = new Rook(2,b.getTile(x, y).getXCoord(), b.getTile(x, y).getYCoord());
                            b.getTile(x, y).setPiece(p);
                            p.setLayoutX(b.getTile(x, y).getXCoord() + PAD_X);
                            p.setLayoutY(b.getTile(x, y).getYCoord() + PAD_Y);
                            pane.getChildren().add(p);
                            break;
                        }
                    case -2:
                        {
                            Piece p = new Rook(-2,b.getTile(x, y).getXCoord(), b.getTile(x, y).getYCoord());
                            b.getTile(x, y).setPiece(p);
                            p.setLayoutX(b.getTile(x, y).getXCoord() + PAD_X);
                            p.setLayoutY(b.getTile(x, y).getYCoord() + PAD_Y);
                            pane.getChildren().add(p);
                            break;
                        }
                    case 3:
                        {
                            Piece p = new Knight(3, b.getTile(x, y).getXCoord(), b.getTile(x, y).getYCoord());
                            b.getTile(x, y).setPiece(p);
                            p.setLayoutX(b.getTile(x, y).getXCoord() + PAD_X);
                            p.setLayoutY(b.getTile(x, y).getYCoord() + PAD_Y);
                            pane.getChildren().add(p);
                            break;
                        }
                    case -3:
                        {
                            Piece p = new Knight(-3,b.getTile(x, y).getXCoord(), b.getTile(x, y).getYCoord());
                            b.getTile(x, y).setPiece(p);
                            p.setLayoutX(b.getTile(x, y).getXCoord() + PAD_X);
                            p.setLayoutY(b.getTile(x, y).getYCoord() + PAD_Y);
                            pane.getChildren().add(p);
                            break;
                        }
                    case 4:
                        {
                            Piece p = new Bishop(4, b.getTile(x, y).getXCoord(),b.getTile(x, y).getYCoord());
                            b.getTile(x, y).setPiece(p);
                            p.setLayoutX(b.getTile(x, y).getXCoord() + PAD_X);
                            p.setLayoutY(b.getTile(x, y).getYCoord() + PAD_Y);
                            pane.getChildren().add(p);
                            break;
                        }
                    case -4:
                        {
                            Piece p = new Bishop(-4, b.getTile(x, y).getXCoord(), b.getTile(x, y).getYCoord());
                            b.getTile(x, y).setPiece(p);
                            p.setLayoutX(b.getTile(x, y).getXCoord() + PAD_X);
                            p.setLayoutY(b.getTile(x, y).getYCoord() + PAD_Y);
                            pane.getChildren().add(p);
                            break;
                        }
                    case 5:
                        {
                            Piece p = new Queen(5,b.getTile(x, y).getXCoord(), b.getTile(x, y).getYCoord());
                            b.getTile(x, y).setPiece(p);
                            p.setLayoutX(b.getTile(x, y).getXCoord() + PAD_X);
                            p.setLayoutY(b.getTile(x, y).getYCoord() + PAD_Y);
                            pane.getChildren().add(p);
                            break;
                        }
                    case -5:
                        {
                            Piece p = new Queen(-5, b.getTile(x, y).getXCoord(), b.getTile(x, y).getYCoord());
                            b.getTile(x, y).setPiece(p);
                            p.setLayoutX(b.getTile(x, y).getXCoord() + PAD_X);
                            p.setLayoutY(b.getTile(x, y).getYCoord() + PAD_Y);
                            pane.getChildren().add(p);
                            break;
                        }
                    case 6:
                        {
                            Piece p = new King(6, b.getTile(x, y).getXCoord(), b.getTile(x, y).getYCoord());
                            b.getTile(x, y).setPiece(p);
                            p.setLayoutX(b.getTile(x, y).getXCoord() + PAD_X);
                            p.setLayoutY(b.getTile(x, y).getYCoord() + PAD_Y);
                            pane.getChildren().add(p);
                            break;
                        }
                    case -6:
                        {
                            Piece p = new King(-6, b.getTile(x, y).getXCoord(), b.getTile(x, y).getYCoord());
                            b.getTile(x, y).setPiece(p);
                            p.setLayoutX(b.getTile(x, y).getXCoord() + PAD_X);
                            p.setLayoutY(b.getTile(x, y).getYCoord() + PAD_Y);
                            pane.getChildren().add(p);
                            break;
                        }
                    case 0:
                    {
                        pane.getChildren().remove(b.getTile(x,y).getPiece());
                    }
                    default:
                        break;
                }
            }
        }
    }
    
}

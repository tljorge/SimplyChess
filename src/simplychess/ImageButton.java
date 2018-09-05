package simplychess;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ImageButton extends Button {
    private final String NORMAL = "-fx-background-color: transparent; -fx-padding: 5, 5, 5, 5;";
    private final String PRESSED = "-fx-background-color: transparent; -fx-padding: 8 3 3 8;";
    
    public ImageButton(String imageurl) {
        setGraphic(new ImageView(new Image(getClass().getResource(imageurl).toString())));
        setStyle(NORMAL);
        
        setOnMousePressed((MouseEvent event) -> {
            setStyle(PRESSED);            
        });
        
        setOnMouseReleased((MouseEvent event) -> {
            setStyle(NORMAL);            
        });
    }
}




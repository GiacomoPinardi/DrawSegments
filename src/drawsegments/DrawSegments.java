/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawsegments;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

/**
 *
 * @author bel22887
 */
public class DrawSegments extends Application{

    
    public static void main(String[] args) {
        
        launch(args);
        
    }

    @Override
    public void start(Stage pStage) {
        
        String fileName = "Cordinates";
        
        Group root = new Group();                
        Canvas canvas = new Canvas(640, 480);        
        GraphicsContext gxt = canvas.getGraphicsContext2D();        
        Drawer d = new Drawer(gxt);
         
        FileReader fr = new FileReader();               
        
        fr.readFile("data/" + fileName.toLowerCase() + ".txt");
        
        d.drawSegments(fr.getCord(), fr.getColor(), fr.getLineWidth(), fr.getContatore());
        
        root.getChildren().add(canvas);
        
        pStage.setScene(new Scene(root));
        
        pStage.show();
        
    }
    
}

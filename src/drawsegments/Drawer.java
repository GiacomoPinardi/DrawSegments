/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawsegments;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *
 * @author bel22887
 */
public class Drawer {
    
    private GraphicsContext gc = null;
    private double w;
    private double h;
    
    public Drawer (GraphicsContext g) {
        this.gc = g;
        this.w = g.getCanvas().getWidth();
        this.h = g.getCanvas().getHeight();
    }
    
    public void drawSegments (double[][] coord, Color[] c, double[] lineWidth, int contatore) {
        
        for (int i = 0; i < contatore; i++) {            
            gc.setStroke(c[i]);
            gc.setLineWidth(lineWidth[i]);
            gc.strokeLine(getX(coord[i][0]), getY(coord[i][1]), getX(coord[i][2]), getY(coord[i][3]));
        }        
        
    }
    
    private double getX (double x) {
        return (w/2) + x;
    }
    
    private double getY (double y) {
        return (h/2) - y;
    }
}

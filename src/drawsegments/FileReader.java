/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawsegments;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javafx.scene.paint.Color;

/**
 *
 * @author bel22887
 */
public class FileReader {
    
    Scanner lettore = null;
    
    private int contatore;
    
    private double[][] cord = new double[1000][4];        
    private Color[] color = new Color[1000];
    private double[] lineWidth = new double[1000];
    
    public void readFile (String fileName) {
            
        File f = new File(fileName);
        
        String[][] cordS = new String[1000][6];               
        
        try {
            lettore = new Scanner(f);
            
        } catch (FileNotFoundException ex) {
            System.out.println("ERRORE: File Not Found!");
        }
        
        this.contatore = 0;
        
        while ((lettore.hasNextLine()) && (cordS.length > contatore)){
            String s = lettore.nextLine();            
            
            cordS[contatore] = s.split(";");
            
            cord[contatore][0] = Double.parseDouble(cordS[contatore][0]);
            cord[contatore][1] = Double.parseDouble(cordS[contatore][1]);
            cord[contatore][2] = Double.parseDouble(cordS[contatore][2]);
            cord[contatore][3] = Double.parseDouble(cordS[contatore][3]);
                 
            color[contatore] = Color.web(cordS[contatore][4]);
            lineWidth[contatore] = Double.parseDouble(cordS[contatore][5]);
            
            contatore ++;
        }  
        
        if (cordS.length <= contatore) {
            System.out.println("ERRORE: Impossibile inserire piu' di " + cordS.length + " segmenti!");
            System.out.println("Gli elementi eccedenti non sono stati disegnati.");
        }
    }
    
    public double[][] getCord () {
        return this.cord;
    }
    
    public Color[] getColor () {
        return this.color;
    }
    
    public double[] getLineWidth () {
        return this.lineWidth;
    }
    
    public int getContatore () {
        return this.contatore;
    }
    
}

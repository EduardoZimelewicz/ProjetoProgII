/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package photochopp;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;



/**
 *
 * @author EDUARDO
 */
public class Operacoes {
    public static BufferedImage complemento(BufferedImage bi) throws IOException{
        int r = 0;
        int g = 0;
        int b = 0;
        
         for(int i = 0; i < bi.getWidth(); i++){
            for(int j = 0; j < bi.getHeight(); j++){
               int bytes = bi.getRGB(i, j);
               Color cor = new Color(bytes,true);
               r = cor.getRed();
               g = cor.getGreen();
               b = cor.getBlue();
               
               int rc = 255 - r;
               int gc = 255 - g;
               int bc = 255 - b;
               
               cor = new Color(rc,gc,bc);
               
               bi.setRGB(i, j, cor.getRGB());
            }
        }
        
        return bi;
         
    }
    
    public static BufferedImage rgbParaCinza(BufferedImage bi){
        int r = 0;
        int g = 0;
        int b = 0;
        
        int i = 0;
        
        for (int k = 0; k < bi.getWidth(); k++){
            for(int j = 0; j < bi.getHeight(); j++){
                int bytes = bi.getRGB(k, j);
                Color cor = new Color(bytes,true);
                r = cor.getRed();
                g = cor.getGreen();
                b = cor.getBlue();
                
                i = (int)((0.3 * r) + (0.59 * g) + (0.11 * b));
                
                cor = new Color(i,i,i);
                
                bi.setRGB(k, j, cor.getRGB());
            }
        }
        
        return bi;
    }
}

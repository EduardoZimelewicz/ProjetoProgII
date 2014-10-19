/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package photochopp;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;



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
               r = bytes >> 16 & 0xFF;
               g = bytes >> 8 & 0xFF;
               b = bytes >> 0 & 0xFF;
               
               int rc = 255 - r;
               int gc = 255 - g;
               int bc = 255 - b;
               
               bytes = rc << 16 | gc << 8 | bc << 0;
               
               bi.setRGB(i, j, bytes);
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
                r = bytes >> 16 & 0xFF;
                g = bytes >> 8 & 0xFF;
                b = bytes >> 0 & 0xFF;
                
                i = (int)((0.3 * r) + (0.59 * g) + (0.11 * b));
                
                bytes = i << 16 | i << 8 | i << 0;
                
                bi.setRGB(k, j, bytes);
            }
        }
        
        return bi;
    }
    
    public static BufferedImage convolucao (BufferedImage f, Filtro w){
        int u = 0;
        int v = 0;
        
        int r = 0;
        int g = 0;
        int b = 0;
        
        int coordenadaX = 0;
        int coordenadaY = 0;
        int coordenadaU = 0;
        int coordenadaV = 0;
        
        for(int i = w.getLength()/2; i < f.getWidth() - w.getLength()/2; i++){
            for(int j = w.getLength()/2; j < f.getHeight() - w.getLength()/2; j++){
                r = 0; g = 0; b = 0;
                for(u = -(w.getLength()/2); u <= (w.getLength()/2); u++){
                    for(v = -(w.getLength()/2); v <= (w.getLength()/2); v++){
                        
                        coordenadaX = i - u;
                        coordenadaY = j - v;
                        
                        coordenadaU = u + (w.getLength()/2);
                        coordenadaV = v + (w.getLength()/2);
                        
                        int bytes1 = f.getRGB(coordenadaX, coordenadaY);
                        int rc = bytes1 >> 16 & 0xFF;
                        int gc = bytes1 >> 8 & 0xFF;
                        int bc = bytes1 >> 0 & 0xFF;
                        
                        r = r + (int) (rc * (w.consulta(coordenadaU, coordenadaV)));
                        g = g + (int) (gc * (w.consulta(coordenadaU, coordenadaV)));
                        b = b + (int) (bc * (w.consulta(coordenadaU, coordenadaV)));
                        
                }
        }
                
                if(r > 255){r = 255;}
                else if(r < 0){r = 0;}
                if(g > 255){g = 255;}
                else if(g < 0){g = 0;}
                if(b > 255){b = 255;}
                else if(b < 0){b = 0;}
                
                int bytes2 = r << 16 | g << 8 | b << 0;
                f.setRGB(i, j, bytes2);        
        }
          
    }
    return f;
}
}

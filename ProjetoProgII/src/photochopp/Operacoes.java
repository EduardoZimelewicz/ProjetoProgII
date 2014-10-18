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
                for(u = -(w.getLength()/2); u <= (w.getLength()/2); u++){
                    for(v = -(w.getLength()/2); v <= (w.getLength()/2); v++){
                        
                        coordenadaX = i - u;
                        coordenadaY = j - v;
                        
                        coordenadaU = u + (w.getLength()/2);
                        coordenadaV = v + (w.getLength()/2);
                        
                        int bytes = f.getRGB(coordenadaX, coordenadaY);
                        Color cor1 = new Color(bytes,true);
                        
                        r = (int) (r + (cor1.getRed() * (w.consulta(coordenadaU, coordenadaV))));
                        g = (int) (g + (cor1.getGreen() * (w.consulta(coordenadaU, coordenadaV))));
                        b = (int) (b + (cor1.getBlue() * (w.consulta(coordenadaU, coordenadaV))));
                        
                }
        }
                
                if(r > 255){r = 255;}
                else if(r < 0){r = 0;}
                if(g > 255){g = 255;}
                else if(g < 0){g = 0;}
                if(b > 255){b = 255;}
                else if(b < 0){b = 0;}
                
                r = r/2;
                g = g/2;
                b = b/2;
                
                Color cor2 = new Color(r, g, b);
                f.setRGB(i, j, cor2.getRGB());        
        }
          
    }
    return f;
}
}

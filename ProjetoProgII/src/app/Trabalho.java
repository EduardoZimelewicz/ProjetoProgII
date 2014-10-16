/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import static photochopp.Operacoes.rgbParaCinza;
import static photochopp.Operacoes.complemento;


/**
 *
 * @author EDUARDO
 */
public class Trabalho {
    public static void main (String [] args){
        try{
 
        File flIn = new File("C:\\Users\\EDUARDO\\Desktop\\Rush.jpg");
        File flOut = new File("C:\\Users\\EDUARDO\\Desktop\\RushConvertido.jpg");
        BufferedImage input = ImageIO.read(flIn);
        //BufferedImage output = complemento(input);
        BufferedImage output = rgbParaCinza(input);
        ImageIO.write(output, "jpg", flOut);
        
        //String operacao = args[0];
        
       /* if(operacao.equals("complemento")){
            output = complemento(input);
        }
               */
        }
               
        
        catch(IOException e){
            e.printStackTrace();
        }
    }
}

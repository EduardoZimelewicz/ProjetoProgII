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
import photochopp.Filtro;
import static photochopp.Operacoes.convolucao;
import static photochopp.Operacoes.complemento;
import static photochopp.Operacoes.rgbParaCinza;


/**
 *
 * @author EDUARDO
 */

public class Trabalho {
    public static void main (String [] args){
        try{
 
        File flIn = new File("C:\\Users\\EDUARDO\\Desktop\\fofos.jpg");
        File flOut = new File("C:\\Users\\EDUARDO\\Desktop\\fofosC.jpg");
        BufferedImage input = ImageIO.read(flIn);
        
        
        double [] [] matrizFiltroGaussiano = new double [] [] {
            {0.0352, 0.0387, 0.0398, 0.0387, 0.0352},  
            {0.0387, 0.0425, 0.0438, 0.0425, 0.0387},
            {0.0398, 0.0438, 0.0452, 0.0438, 0.0398},
            {0.0387, 0.0425, 0.0438, 0.0425, 0.0387},
            {0.0352, 0.0387, 0.0398, 0.0387, 0.0352}
        };
        
        double [] [] matrizRealcarBordas = new double [] []{
            {0, 0, 0},
            {-1, 1, 0},
            {0, 0, 0}
        }; 
        
        Filtro fGauss = new Filtro(matrizFiltroGaussiano, matrizFiltroGaussiano.length);
        Filtro fRealcarBordas = new Filtro(matrizRealcarBordas, matrizRealcarBordas.length);
        //BufferedImage output = complemento(input);
        //BufferedImage output = rgbParaCinza(input);
        BufferedImage output = convolucao (input, fGauss); //Funcionando
        //BufferedImage output = convolucao(input, fRealcarBordas); //Funcionando
        ImageIO.write(output, "jpg", flOut);
        
        //String operacao = args[0];
    
       /* if(operacao.equals("complemento")){s
            output = complemento(input);
        }
               */
        }
               
        catch(IOException e){
            e.printStackTrace();
        }
    }
}

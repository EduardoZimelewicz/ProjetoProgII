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
 
        File flIn = new File("C:\\Users\\EDUARDO\\Desktop\\cão.png");
        File flOut = new File("C:\\Users\\EDUARDO\\Desktop\\foto1Cão.png");
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
        
        double [] [] matrizAgucar = new double [] []{
            {0, 0, 0, 0, 0},
            {0, 0, -1, 0, 0},
            {0,-1, 5, -1, 0},
            {0, 0, -1, 0, 0},
            {0, 0, 0, 0, 0}
        };
        
        double [] [] matrizDetectar = new double [] []{
            {0, 1, 0},
            {1, -4, 1},
            {0, 1, 0}
        };
        
        double [] [] matrizDestacar = new double [] []{
            {-2, -1, 0},
            {-1, 1, 1},
            {0, 1, 2}
        };
       
       
        Filtro fGauss = new Filtro(matrizFiltroGaussiano, matrizFiltroGaussiano.length);
        Filtro fRealcarBordas = new Filtro(matrizRealcarBordas, matrizRealcarBordas.length);
        Filtro fAgucar = new Filtro(matrizAgucar, matrizAgucar.length);
        Filtro fDetectar = new Filtro (matrizDetectar, matrizDetectar.length);
        Filtro fDestacar = new Filtro (matrizDestacar, matrizDestacar.length);
        //BufferedImage output = complemento(input);
        //BufferedImage output = rgbParaCinza(input);
        //BufferedImage output = convolucao (input, fGauss); //Funcionando
        BufferedImage output = convolucao(input, fRealcarBordas); //Funcionando
        //BufferedImage output = convolucao(input, fDetectar); //Não está funcionando
        //BufferedImage output = convolucao(input, fAgucar); //Funcionanado
        //BufferedImage output = convolucao(input, fDestacar); //Não está funcionando
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

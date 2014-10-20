/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package photochopp;

/**
 *
 * @author EDUARDO
 */
public class Filtro {
    protected double [] [] matrizDoFiltro;
       
    public Filtro(double [] [] matrizDoFiltro){
        if(matrizDoFiltro.length % 2 == 0){
            throw new IllegalArgumentException("O matriz do filtro deve ter um tamanho ímpar!");
        }
        this.matrizDoFiltro = matrizDoFiltro;
    }
    
    public int getLength(){
        return this.matrizDoFiltro.length;
    }
    
    public double consulta(int l, int m){
        return this.matrizDoFiltro[l][m];
    }
    
}

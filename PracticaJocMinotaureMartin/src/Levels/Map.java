/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Levels;

import java.util.Arrays;

/**
 *
 * @author alumnegs
 */
public class Map {

    public Map() {
    }
    
   
    private char[][] mapa = {
        {'.', '#', '#', '#', '#', '#', '#', '#', '#', '.'},
        {'|', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', '|'},
        {'|', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', '|'},
        {'|', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', '|'},
        {'|', 'P', 'P', 'P', 'J', 'P', 'P', 'P', 'P', '|'},
        {'|', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', '|'},
        {'|', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', '|'},
        {'|', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', '|'},
        {'|', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', '|'},
        {'|', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', '|'},
        {'|', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', '|'},
        {'|', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', '|'},
        {'|', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', '|'},
        {'|', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', '|'},
        {'|', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', '|'},
        {'|', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', '|'},
        {'|', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', '|'},
        {'|', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', '|'},
        {'|', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', '|'},
        {'.', '#', '#', '#', '#', '#', '#', '#', '#', '.'}};
        
    public char getCaracterEnCoordenada(int x, int y){
        
        if (x >= 0 && x < mapa.length && y >= 0 && y < mapa[0].length){
            return mapa[x][y];
        }
        else {
            throw new IllegalArgumentException("coordenades fora de rang!");
        }
        
    }
    public int[] getCoordenadas(char caracter){
        
        
        for (int ii = 0; ii < mapa.length; ii ++){
            for (int jj = 0; jj < mapa[0].length; jj ++){
                if(mapa[ii][jj] == caracter){
                    return new int[]{ii,jj};
                    
                }
            }
        }
        
        return null;
    }
    
    public void setCoordenadas(int x, int y, char caracter){
        
        int xActual = -1;
        int yActual = -1;
        
        for (int ii = 0; ii < mapa.length;ii++){
            for (int jj = 0;  jj< mapa[ii].length;jj++){
                if(mapa[ii][jj] == caracter){
                    xActual = ii;
                    yActual = jj;
                    break;
                }
            }
        }
        
        
        if (xActual != -1 && yActual != -1){
            mapa[xActual][yActual] = 'P';
            mapa[x][y] = caracter;
        }
        
        
    }
    

    public char[][] getMapa() {
        return mapa;
    }

   
    
    


    public void setMapa(char[][] mapa) {
        this.mapa = mapa;
    }
    
    
    public void mostrarMapa(char[][] mapa){
        for (int x = 0; x < mapa.length;x++){
            for (int y = 0; y < mapa[x].length;y++){
               System.out.print("\033[0;96m" + mapa[x][y] + "\033[0m" + "  ");
               
            }
            System.out.println();
        }
    }
    
    
    

}

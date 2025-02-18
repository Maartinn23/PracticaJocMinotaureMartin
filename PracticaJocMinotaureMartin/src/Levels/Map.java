/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Levels;

import java.util.Arrays;

/**
 *
 * @author alumnegs
 * TODO: Ajustar matriz, añadir J,M y E al mapa, logica juego...
 */
public class Map {

    public Map() {
    }
    
   
    private char[][] mapa = {
        {'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P'},
        {'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P'},
        {'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P'},
        {'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P'},
        {'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P'},
        {'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P'},
        {'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P'},
        {'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P'},
        {'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P'},
        {'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P'},
        {'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P'},
        {'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P'},
        {'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P'},
        {'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P'},
        {'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P'},
        {'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P'},
        {'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P'},
        {'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P'},
        {'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P'},
        {'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P'}};
        

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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

import KeyInputs.KeyInput;
import Levels.Map;
import Renderer.Renderer;
import Utilities.ConsoleColors;
import java.io.IOException;

/**
 *
 * @author alumnegs
 * // TODO: Acabar movimiento de J, si llega a pared, impedir movimiento.
 */
public class Player extends Entity {
    
    
    protected  char caracter = 'J';
    protected String colorEntitat = ConsoleColors.GREEN; 
    protected int x;
    protected int y;
    
    
    public void move(KeyInput keyInput, Map mapa, char caracter, char entradaUsuari) throws IOException, InterruptedException{
        
        int[] coordenadesActuals = mapa.getCoordenadas(caracter);
        int novaX = coordenadesActuals[0];
        int novaY = coordenadesActuals[1];
               
            switch(entradaUsuari){
                
                case 'w':
                case 'W':
                    novaX -= 1;
                    mapa.setCoordenadas(novaX, novaY, caracter);
                    break;
                
                case 's':
                case 'S':
                    novaX += 1;
                    mapa.setCoordenadas(novaX, novaY, caracter);
                    break;
                case 'a':
                case 'A':
                    novaY -= 1;
                    mapa.setCoordenadas(novaX, novaY, caracter);
                    break;
                case 'd':
                case 'D':
                    novaY += 1;
                    mapa.setCoordenadas(novaX, novaY, caracter);
                    break;
                    

            
                    
        }
        

        
        
        
    }
    
    
    
    
    
    
    
}

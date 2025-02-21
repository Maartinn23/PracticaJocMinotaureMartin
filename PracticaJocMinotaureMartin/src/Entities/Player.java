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
                   System.out.println(coordenadesActuals[0] + " " + coordenadesActuals[1]);

               
        if(entradaUsuari == 'w' || entradaUsuari == 'W'){
            
            int novaX = coordenadesActuals[0] - 1;
            int novaY = coordenadesActuals[1];
            
            
            mapa.setCoordenadas(novaX, novaY, caracter);
 
            
            
            
        }
        
        
        
    }
    
    
    
    
    
    
    
}

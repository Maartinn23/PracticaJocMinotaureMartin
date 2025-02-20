/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

import KeyInputs.KeyInput;
import Levels.Map;
import Utilities.ConsoleColors;

/**
 *
 * @author alumnegs
 */
public class Player extends Entity {
    
    
    protected  char caracter = 'J';
    protected String colorEntitat = ConsoleColors.GREEN; 
    protected int x = 0;
    protected int y = 0;
    
    
    public void move(KeyInput keyInput, Map mapa){
        
        char entradaUsuari = keyInput.getC();
        
        if(entradaUsuari == 'w' || entradaUsuari == 'W'){
            
        }
        
        
        
    }
    
    
    
    
    
    
    
}

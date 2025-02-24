package Principal;

import Entities.Minotaur;
import KeyInputs.KeyInput;
import Levels.Map;
import java.awt.Component;
import java.io.IOException;
import Renderer.Renderer;
/**
 *
 * @author alumnegs
 * // TODO Arreglar problema con renderer y Minotauro
 */
public class Principal {
    public static void main(String[] args) throws IOException {
        
        Map mapa = new Map();
        
        Renderer renderer = new Renderer(mapa);

        KeyInput keyInput = new KeyInput(mapa,renderer);
        renderer.keyInput = keyInput;
           
        Thread filKeyInput = new Thread(keyInput);

        System.out.println("Carregant joc...");

        
        
        
    
        filKeyInput.start();
    }
}


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

        KeyInput keyInput = new KeyInput(mapa);
           
        Thread filKeyInput = new Thread(keyInput);

        System.out.println("Carregant joc...");

        filKeyInput.start();
        
        //Minotaur minotaure = new Minotaur(mapa, keyInput);
        //Thread filMinotaure = new Thread(minotaure);

        //filMinotaure.start();
    }
}


package Principal;

import KeyInputs.KeyInput;
import java.awt.Component;
import java.io.IOException;
import Renderer.Renderer;
/**
 *
 * @author alumnegs
 */
public class Principal {
    public static void main(String[] args) throws IOException {
        KeyInput keyInput = new KeyInput();
        
           
        Thread filKeyInput = new Thread(keyInput);

        System.out.println("Carregant joc...");

        filKeyInput.start();
    }
}


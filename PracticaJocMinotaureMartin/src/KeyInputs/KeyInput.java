package KeyInputs;

import Renderer.Renderer;
import java.io.IOException;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import Utilities.ConsoleColors;

public class KeyInput implements Runnable {

    public KeyInput(String estatJoc, boolean game) {
        this.estatJoc = estatJoc;
        this.game = game;
    }

    public KeyInput() {
        this.estatJoc = "menuPrincipal";
        this.game = true;
    }

    private String estatJoc;
    private boolean game;
    private int input;
    private char c;

    @Override
    public void run() {
        try {

            Terminal terminal = TerminalBuilder.builder().system(true).build();

            Renderer renderer = new Renderer();

            String estatAnterior = "";

            if (!estatAnterior.equals(estatJoc)) {
                renderer.renderJoc(this);
                estatAnterior = estatJoc;

            }

            renderer.renderJoc(this);

            estatJoc = "menu principal";

            while (game) {
                renderer.renderJoc(this);

                input = terminal.reader().read();
                c = (char) input;
                
               
                switch (c) {
                    case 'q':
                    case 'Q':
                        estatJoc = "game over";
                        game = false;
  
                 
//                        
                      break;
                    case 'i':
                        estatJoc = "menu instruccions";
                        break;

                }

            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String getEstatJoc() {
        return estatJoc;
    }

    public void setEstatJoc(String estatJoc) {
        this.estatJoc = estatJoc;
    }

    public boolean isGame() {
        return game;
    }

    public void setGame(boolean game) {
        this.game = game;
    }

    public int getInput() {
        return input;
    }

    public void setInput(int input) {
        this.input = input;
    }

    public char getC() {
        return c;
    }

    public void setC(char c) {
        this.c = c;
    }

}

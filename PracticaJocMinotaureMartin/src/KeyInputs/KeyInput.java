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
            renderer.renderJoc(this);

            while (game) {

                input = terminal.reader().read();
                c = (char) input;

                if (c == 'q' || c == 'Q') {
                    game = false;
                }
                
                switch(estatJoc){
                    default:
                        estatJoc = "menuPrincipal";
                        
                        
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

}

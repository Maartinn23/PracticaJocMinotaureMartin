package KeyInputs;

import Renderer.Renderer;
import java.io.IOException;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import Utilities.ConsoleColors;

public class KeyInput implements Runnable {

    private String estatJoc;
    private boolean game;
    private int input;
    private char c;
    private int seleccionador;

    public KeyInput(String estatJoc, boolean game) {
        this.estatJoc = estatJoc;
        this.game = game;
    }

    public KeyInput() {
        this.estatJoc = "menuPrincipal";
        this.game = true;
    }

    @Override
    public void run() {
        try {
            Terminal terminal = TerminalBuilder.builder()
                    .system(true)
                    .dumb(true) 
                    .build();
            terminal.enterRawMode();

            Renderer renderer = new Renderer();
            seleccionador = 1;
            estatJoc = "menu principal";

            renderer.renderMenu(this);

            while (game) {
                input = terminal.reader().read();
                c = (char) input;

                switch (c) {
                    case 'q':
                    case 'Q':
                        estatJoc = "game over";
                        game = false;
                        break;
                    case 'w':
                    case 'W':
                        if (seleccionador < 3) {
                            seleccionador += 1;
                        } else {
                            seleccionador = 1;
                        }
                        renderer.renderMenu(this);
                        break;
                    case 's':
                    case 'S':
                        if (seleccionador > 1) {
                            seleccionador -= 1;
                        } else {
                            seleccionador = 3;
                        }
                        renderer.renderMenu(this);
                        break;
                    case ' ':
                        if (seleccionador == 1) {
                            estatJoc = "iniciar partida";
                        } else if (seleccionador == 2) {
                            estatJoc = "menu instruccions";
                        }
                        renderer.renderMenu(this);
                        break;
                }
            }

            // Mensaje al salir
            terminal.writer().println(ConsoleColors.PURPLE + "---- SORTINT DEL JOC ----" + ConsoleColors.RESET);
            terminal.writer().flush();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String getEstatJoc() {
        return estatJoc;
    }

    public boolean isGame() {
        return game;
    }

    public int getSeleccionador() {
        return seleccionador;
    }
}

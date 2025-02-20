package KeyInputs;

import Renderer.Renderer;
import java.io.IOException;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import Utilities.ConsoleColors;
import java.util.logging.Level;
import java.util.logging.Logger;

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

            renderer.renderMenu(this);

            while (game) {
                input = terminal.reader().read();
                c = (char) input;

                switch (c) {
                    case 'q':
                    case 'Q':
                        estatJoc = "gameOver";
                        game = false;
                        break;

                    case 'w':
                    case 'W':
                        if (estatJoc.equals("menuPrincipal")) {
                            if (seleccionador < 3) {
                                seleccionador += 1;
                            } else {
                                seleccionador = 1;
                            }
                            renderer.renderMenu(this);
                        }
                        break;

                    case 's':
                    case 'S':
                        if (estatJoc.equals("menuPrincipal")) {
                            if (seleccionador > 1) {
                                seleccionador -= 1;
                            } else {
                                seleccionador = 3;
                            }
                            renderer.renderMenu(this);
                        }
                        break;

                    case ' ':
                        if (estatJoc.equals("menuPrincipal")) {
                            if (seleccionador == 1) {
                                estatJoc = "partidaIniciada";
                                renderer.renderMapa(this);
                            } else if (seleccionador == 2) {
                                estatJoc = "menuInstruccions";
                                renderer.renderMenuInstruccions(this);

                            } else if (seleccionador == 3) {
                                estatJoc = "salir";
                                game = false;
                            }
                        } else if (estatJoc.equals("menuInstruccions")) {
                            estatJoc = "menuPrincipal";
                            renderer.renderMenu(this);
                        } else if (estatJoc.equals("partidaIniciada")) {
                            estatJoc = "menuPrincipal";
                            renderer.renderMenu(this);
                        }

                        break;
                }
            }

            terminal.writer().println(ConsoleColors.PURPLE + "---- SORTINT DEL JOC ----" + ConsoleColors.RESET);
            terminal.writer().flush();

        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (InterruptedException ex) {
            Logger.getLogger(KeyInput.class.getName()).log(Level.SEVERE, null, ex);
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

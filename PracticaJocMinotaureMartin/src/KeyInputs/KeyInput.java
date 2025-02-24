package KeyInputs;

import Entities.Minotaur;
import Levels.Map;
import Renderer.Renderer;
import java.io.IOException;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import Utilities.ConsoleColors;
import java.util.logging.Level;
import java.util.logging.Logger;

// TODO: arreglar logica de enviar input renderer.renderMapa para que funcione el metodo move().
public class KeyInput implements Runnable {

    private Map mapa;

    private String estatJoc;
    private boolean game;
    private int input;
    private char c;
    private int seleccionador;
    private Renderer renderer;

    public KeyInput(Map mapa, Renderer renderer) {
        this.mapa = mapa;
        this.game = true;
        this.estatJoc = "menuPrincipal";
        this.renderer = renderer;

    }

    @Override
    public void run() {
        try {
            Terminal terminal = TerminalBuilder.builder()
                    .system(true)
                    .dumb(true)
                    .build();
            terminal.enterRawMode();

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
                        } else if (estatJoc.equals("partidaIniciada")) {
                            renderer.renderMovimentJugador(this);
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
                        } else if (estatJoc.equals("partidaIniciada")) {
                            renderer.renderMovimentJugador(this);
                        }
                        break;
                    case 'a':
                    case 'A':
                        if (estatJoc.equals("partidaIniciada")) {
                            renderer.renderMovimentJugador(this);
                        }
                        break;
                    case 'd':
                    case 'D':
                        if (estatJoc.equals("partidaIniciada")) {
                            renderer.renderMovimentJugador(this);
                        }
                        break;

                    case ' ':
                        if (estatJoc.equals("menuPrincipal")) {
                            if (seleccionador == 1) {
                                estatJoc = "partidaIniciada";
                                renderer.renderMapa(this);

                                Minotaur minotaure = new Minotaur(mapa, this, renderer);
                                Thread filMinotaure = new Thread(minotaure);

                                filMinotaure.start();
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

            terminal.writer().println(ConsoleColors.RED + "---- SORTINT DEL JOC ----" + ConsoleColors.RESET);
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

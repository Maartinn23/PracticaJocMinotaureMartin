package Renderer;

import KeyInputs.KeyInput;
import Utilities.ConsoleColors;
import java.io.IOException;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

public class Renderer {

    public Renderer() {

    }

    public void renderMenu(KeyInput keyInput) throws IOException {

        Terminal terminal = TerminalBuilder.builder().system(true).build();
        try {
            new ProcessBuilder("clear").inheritIO().start().waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        switch (keyInput.getSeleccionador()) {

            case 1:
                terminal.writer().println("---- MENU PRINCIPAL ----");
                terminal.writer().println("\033[4;37m" + "Inicia el joc" + "\033[0m");
                terminal.writer().println("Mostra les instruccions");
                terminal.writer().println("Sortir del joc");
                terminal.writer().flush();
                break;
            case 2:
                terminal.writer().println("---- MENU PRINCIPAL ----");
                terminal.writer().println("Inicia el joc");
                terminal.writer().println("\033[4;37m" + "Mostra les instruccions" + "\033[0m");
                terminal.writer().println("Sortir del joc");
                terminal.writer().flush();
                break;
            case 3:
                terminal.writer().println("---- MENU PRINCIPAL ----");
                terminal.writer().println("Inicia el joc");
                terminal.writer().println("Mostra les instruccions");
                terminal.writer().println("\033[4;37m" + "Sortir del joc" + "\033[0m");
                terminal.writer().flush();
                break;

        }

    }

}

package Renderer;

import KeyInputs.KeyInput;
import Levels.Map;
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

    public void renderMenuInstruccions(KeyInput keyInput) throws IOException {
        Terminal terminal = TerminalBuilder.builder().system(true).build();
        try {
            new ProcessBuilder("clear").inheritIO().start().waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        terminal.writer().println("\033[0;33m" + "---- INSTRUCCIONS DEL JOC ----" + "\033[0m");
        terminal.writer().println("-Moute amb w-a-s-d");
        terminal.writer().println("-Ves fins la sortida (E al mapa)");
        terminal.writer().println("\033[0;31m" + "-Evita al minotaure" + "\033[0m");
        terminal.writer().println("");
        terminal.writer().println("Pressiona la tecla espai per tornar al menu principal");
        terminal.writer().flush();
       
    }
    
    public void renderMapa(KeyInput keyInput) throws IOException, InterruptedException{
        
        Terminal terminal = TerminalBuilder.builder().system(true).build();
        try {
            new ProcessBuilder("clear").inheritIO().start().waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        
        Map mapa = new Map();
//        mapa.mostrarMapa(mapa.getMapa());

        
    }
    
}

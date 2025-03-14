package Renderer;

import Entities.Minotaur;
import Entities.Player;
import KeyInputs.KeyInput;
import Levels.Map;
import Utilities.ConsoleColors;
import java.io.IOException;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

public class Renderer {
    
    
    private Map mapa;
    private Player jugador = new Player();
    public KeyInput keyInput;
    private Minotaur minotaure = new Minotaur(mapa,keyInput,this);
    
    public Renderer(Map mapa){
        
       this.mapa = mapa;
        
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
    
    public char[][] renderMapa(KeyInput keyInput) throws IOException, InterruptedException{
        try {
            new ProcessBuilder("clear").inheritIO().start().waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        
        mapa.mostrarMapa(mapa.getMapa());
        
        return mapa.getMapa();
       
        
    }
    
    public void renderMovimentJugador(KeyInput keyInput) throws IOException, InterruptedException{
        
        try {
            new ProcessBuilder("clear").inheritIO().start().waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        jugador.move(keyInput, mapa, jugador.getCaracter(), keyInput.getC());
        
        renderMapa(keyInput);
                
    }

    public void renderMovimentMinotaure(KeyInput keyInput) throws IOException,InterruptedException{
        
        try {
            new ProcessBuilder("clear").inheritIO().start().waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        
        minotaure.moveMinotaur(mapa, minotaure.getCaracter(), jugador.getCaracter());
        
        renderMapa(keyInput);
   
    }
    

}

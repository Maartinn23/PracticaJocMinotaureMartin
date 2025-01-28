/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Renderer;

import KeyInputs.KeyInput;
import Utilities.ConsoleColors;
import java.io.IOException;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

/**
 *
 * @author alumnegs
 */
public class Renderer {

    private final Terminal terminal;

    public Renderer() throws IOException {
        this.terminal = TerminalBuilder.builder().system(true)
                .system(true)
                .dumb(true)
                .build();

    }

    public void renderJoc(KeyInput keyInput) throws IOException {

        try {
            new ProcessBuilder("clear").inheritIO().start().waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

//            terminal.writer().println(ConsoleColors.YELLOW + "---- BENVINGUT AL JOC DEL MINOTAURE ----" + ConsoleColors.RESET);
//            terminal.writer().flush();
        switch (keyInput.getEstatJoc()) {
            case "menu principal":
                terminal.writer().println("---- MENU PRINCIPAL ----");
                terminal.writer().println("-Inicia el joc");
                terminal.writer().println("-Mostra les instruccions");
                terminal.writer().println("-Pressiona q per sortir del joc");
                               
                terminal.writer().flush();
                
                break;
            case "game over":
                terminal.writer().println(ConsoleColors.PURPLE + "---- SORTINT DEL JOC ----" + ConsoleColors.RESET);
                terminal.writer().flush();
                break;
            case "menu instruccions":
                terminal.writer().println("---- INSTRUCCIONS DEL JOC ----");
                terminal.writer().println("1. Mou-te amb les fletxes.");
                terminal.writer().println("2. Evita el minotaure.");
                terminal.writer().println("3. Troba la sortida.");
                terminal.writer().flush();
                break;

        }

    }
}

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
        this.terminal = TerminalBuilder.builder().system(true).build();

    }

    public void renderJoc(KeyInput keyInput) throws IOException {
        
        boolean loop = keyInput.isGame();

        if (keyInput.getEstatJoc().equals("menuPrincipal")) {
            Terminal terminal = TerminalBuilder.builder().system(true).build();

            terminal.writer().println(ConsoleColors.YELLOW + "---- BENVINGUT AL JOC DEL MINOTAURE ----" + ConsoleColors.RESET);
            terminal.writer().flush();

            while (loop) {
                terminal.writer().println("---- MENU PRINCIPAL ----");
                terminal.writer().println("-Inicia el joc");
                terminal.writer().println("-Mostra les instruccions");
                terminal.writer().println("-Pressiona q per sortir del joc");
                terminal.writer().flush();

            }

            terminal.writer().println(ConsoleColors.PURPLE + "---- SORTINT DEL JOC ----" + ConsoleColors.RESET);
            terminal.writer().flush();

        }
    }

}

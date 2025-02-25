/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

import KeyInputs.KeyInput;
import Levels.Map;
import Renderer.Renderer;
import Utilities.ConsoleColors;
import java.io.IOException;

/**
 *
 * @author alumnegs
 */
public class Player extends Entity {

    protected char caracter = 'J';
    protected String colorEntitat = "\033[0;32m";

    public char getCaracter() {
        return caracter;
    }

    public void setCaracter(char caracter) {
        this.caracter = caracter;
    }

    public String getColorEntitat() {
        return colorEntitat;
    }

    public void setColorEntitat(String colorEntitat) {
        this.colorEntitat = colorEntitat;
    }

    public void move(KeyInput keyInput, Map mapa, char caracter, char entradaUsuari)
            throws IOException, InterruptedException {

        int[] coordenadesActuals = mapa.getCoordenades(caracter);
        int novaX = coordenadesActuals[0];
        int novaY = coordenadesActuals[1];

        switch (entradaUsuari) {

            case 'w':
            case 'W':
                if (!mapa.delimitadorMapa(mapa.getMapa(), (novaX - 1), novaY)) {
                    novaX -= 1;
                    mapa.setCoordenadas(novaX, novaY, caracter);
                }
                break;

            case 's':
            case 'S':
                if (!mapa.delimitadorMapa(mapa.getMapa(), (novaX + 1), novaY)) {
                    novaX += 1;
                    mapa.setCoordenadas(novaX, novaY, caracter);
                }
                break;
            case 'a':
            case 'A':
                if (!mapa.delimitadorMapa(mapa.getMapa(), novaX, (novaY - 1))) {
                    novaY -= 1;
                    mapa.setCoordenadas(novaX, novaY, caracter);
                }
                break;
            case 'd':
            case 'D':
                if (!mapa.delimitadorMapa(mapa.getMapa(), novaX, (novaY + 1))) {
                    novaY += 1;
                    mapa.setCoordenadas(novaX, novaY, caracter);
                }
                break;

        }

    }

    public Player() {

    }

    public Player(char caracter, String colorEntitat) {
        super(caracter, colorEntitat);
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

import KeyInputs.KeyInput;
import Levels.Map;
import Renderer.Renderer;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alumnegs
 */
public class Minotaur extends Entity implements Runnable {

    protected char caracter = 'M';
    protected String colorEntitat = "\033[0;31m";

    protected Renderer renderer;
    protected KeyInput keyInput;

    protected Map mapa;

    public Minotaur(Map mapa, KeyInput keyInput, Renderer renderer) {

        this.mapa = mapa;
        this.keyInput = keyInput;
        this.renderer = renderer;

    }

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

    public void moveMinotaur(Map mapa, char caracter, char caracter2) throws InterruptedException {

        int[] coordenadesActuals = mapa.getCoordenades(caracter);
        int novaX = coordenadesActuals[0];
        int novaY = coordenadesActuals[1];

        int[] coordenadesActualsJugador = mapa.getCoordenades(caracter2);
        int actualX = coordenadesActualsJugador[0];
        int actualY = coordenadesActualsJugador[1];

        if (novaX != actualX) {
            if (novaX < actualX) {
                novaX++;
            } else {
                novaX--;
            }
        } 

        if (novaY != actualY) {
            if (novaY < actualY) {
                novaY++;
            } else {
                novaY--;
            }
        }
        
        mapa.setCoordenadas(novaX, novaY, caracter);
        
        
    }

    {
    }

    @Override
    public void run() {

        while (!mapa.isJugadorArribaSortida() | !mapa.isMinotaureAtrapaJugador() && keyInput.isGame()) {
            try {

                Thread.sleep(500);

                renderer.renderMovimentMinotaure(keyInput);
                
                if (mapa.isJugadorArribaSortida()) {
                    Thread.currentThread().interrupt();
                }
                
                if (mapa.isMinotaureAtrapaJugador()) {
                    Thread.currentThread().interrupt();
                }

                if (keyInput.getC() == 'q' || keyInput.getC() == 'Q') {
                    return;
                }

            } catch (IOException ex) {
                Logger.getLogger(Minotaur.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(Minotaur.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

}

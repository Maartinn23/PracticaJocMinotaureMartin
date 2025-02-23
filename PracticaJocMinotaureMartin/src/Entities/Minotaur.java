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

    public void moveMinotaur(Map mapa, char caracter) {

        int[] coordenadesActuals = mapa.getCoordenades(caracter);
        int novaX = coordenadesActuals[0];
        int novaY = coordenadesActuals[1];

        Random movAleatori = new Random();
        int posibleMov = movAleatori.nextInt(1, 5);

        switch (posibleMov) {

            case 1:
                if (!mapa.delimitadorMapa(mapa.getMapa(), (novaX - 1), novaY)) {
                    novaX -= 1;
                    mapa.setCoordenadas(novaX, novaY, caracter);
                }
                break;

            case 2:
                if (!mapa.delimitadorMapa(mapa.getMapa(), (novaX + 1), novaY)) {
                    novaX += 1;
                    mapa.setCoordenadas(novaX, novaY, caracter);
                }
                break;

            case 3:
                if (!mapa.delimitadorMapa(mapa.getMapa(), novaX, (novaY - 1))) {
                    novaY -= 1;
                    mapa.setCoordenadas(novaX, novaY, caracter);
                }
                break;

            case 4:
                if (!mapa.delimitadorMapa(mapa.getMapa(), novaX, (novaY + 1))) {
                    novaY += 1;
                    mapa.setCoordenadas(novaX, novaY, caracter);
                }
                break;

        }

    }

    @Override
    public void run() {
        try {
            renderer.renderMovimentMinotaure(keyInput);
        } catch (IOException ex) {
            Logger.getLogger(Minotaur.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Minotaur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

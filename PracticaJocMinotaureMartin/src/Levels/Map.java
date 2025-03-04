/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Levels;

import Entities.Entity;
import Entities.Player;
import Renderer.Renderer;
import java.util.Arrays;

/**
 *
 * @author alumnegs
 */
public class Map {

    private boolean minotaureAtrapaJugador = false;
    private boolean jugadorArribaSortida = false;

    public Map() {
    }

    private char[][] mapa = {
        {'.', '~', '~', '~', '~', '~', '~', '~', '~', '.'},
        {'|', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', '|'},
        {'|', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', '|'},
        {'|', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', '|'},
        {'|', 'J', 'P', 'P', 'P', 'P', 'P', 'P', 'P', '|'},
        {'|', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', '|'},
        {'|', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', '|'},
        {'|', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', '|'},
        {'|', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', '|'},
        {'|', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', '|'},
        {'|', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', '|'},
        {'|', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', '|'},
        {'|', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', '|'},
        {'|', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', '|'},
        {'|', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', '|'},
        {'|', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', '|'},
        {'|', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'M', '|'},
        {'|', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'E', '|'},
        {'|', 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P', '|'},
        {'.', '~', '~', '~', '~', '~', '~', '~', '~', '.'}};

    public char getCaracterEnCoordenada(int x, int y) {

        if (x >= 0 && x < mapa.length && y >= 0 && y < mapa[0].length) {
            return mapa[x][y];
        } else {
            throw new IllegalArgumentException("coordenades fora de rang!");
        }

    }

    public int[] getCoordenades(char caracter) {

        for (int ii = 0; ii < mapa.length; ii++) {
            for (int jj = 0; jj < mapa[0].length; jj++) {
                if (mapa[ii][jj] == caracter) {
                    return new int[]{ii, jj};

                }
            }
        }

        return null;
    }

    public void setCoordenadas(int x, int y, char caracter) {

        int xActual = -1;
        int yActual = -1;

        int[] coordenadesMeta = this.getCoordenades('E');

        int xMeta = -1;
        int yMeta = -1;

        if (coordenadesMeta != null) {
            xMeta = coordenadesMeta[0];
            yMeta = coordenadesMeta[1];
        }

        for (int ii = 0; ii < mapa.length; ii++) {
            for (int jj = 0; jj < mapa[ii].length; jj++) {
                if (mapa[ii][jj] == caracter) {
                    xActual = ii;
                    yActual = jj;
                    break;
                }
            }
        }

        if (caracter == 'M' && mapa[x][y] == 'J') {
            minotaureAtrapaJugador = true;

        }

        if (xActual != -1 && yActual != -1) {
            if (mapa[x][y] != 'M') {
                mapa[xActual][yActual] = 'P';
                mapa[x][y] = caracter;

                if (x == xMeta && y == yMeta) {
                    jugadorArribaSortida = true;
                }

            }

        }

    }

    public char[][] getMapa() {
        return mapa;
    }

    public void setMapa(char[][] mapa) {
        this.mapa = mapa;
    }

    public void mostrarMapa(char[][] mapa) {
        for (int x = 0; x < mapa.length; x++) {
            for (int y = 0; y < mapa[x].length; y++) {
                if (mapa[x][y] == 'J') {
                    System.out.print("\033[0;32m" + mapa[x][y] + "\033[0m" + "  ");

                } else {
                    if (mapa[x][y] == 'M') {
                        System.out.print("\033[0;31m" + mapa[x][y] + "\033[0m" + "  ");

                    } else {
                        if (mapa[x][y] == 'E') {
                            System.out.print("\033[0;33m" + mapa[x][y] + "\033[0m" + "  ");

                        } else {
                            System.out.print("\033[0;35m" + mapa[x][y] + "\033[0m" + "  ");
                        }
                    }
                }
            }
            System.out.println();
        }
    }

    public boolean delimitadorMapa(char[][] mapa, int x, int y) {

        for (int ii = 0; ii < mapa.length; ii++) {
            for (int jj = 0; jj < mapa[0].length; jj++) {
                if (mapa[ii][jj] == mapa[x][y]) {
                    if (mapa[x][y] == '|' || mapa[x][y] == '~') {
                        return true;

                    }
                }

            }
        }

        return false;

    }

    public boolean isMinotaureAtrapaJugador() {
        return minotaureAtrapaJugador;
    }

    public void setMinotaureAtrapaJugador(boolean minotaureAtrapaJugador) {
        this.minotaureAtrapaJugador = minotaureAtrapaJugador;
    }

    public boolean isJugadorArribaSortida() {
        return jugadorArribaSortida;
    }

    public void setJugadorArribaSortida(boolean jugadorArribaSortida) {
        this.jugadorArribaSortida = jugadorArribaSortida;
    }

}

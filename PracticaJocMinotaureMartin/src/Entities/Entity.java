/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

/**
 *
 * @author Martin
 */
public class Entity {

    public Entity() {

    }

    public Entity(int x, int y, char caracter, String colorEntitat) {
        this.x = x;
        this.y = y;
        this.caracter = caracter;
        this.colorEntitat = colorEntitat;
    }

    // Atributs classe pare
    protected int x;
    protected int y;
    protected char caracter;
    protected String colorEntitat;

    // Getters y setters
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public char getCharacter() {
        return caracter;
    }

    public String getColorEntitat() {
        return colorEntitat;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setCharacter(char caracter) {
        this.caracter = caracter;
    }

    public void setColorEntitat(String colorEntitat) {
        this.colorEntitat = colorEntitat;
    }

}

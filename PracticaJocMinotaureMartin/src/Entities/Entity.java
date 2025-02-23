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

    public Entity(char caracter, String colorEntitat) {

        this.caracter = caracter;
        this.colorEntitat = colorEntitat;
    }

    // Atributs classe pare

    protected char caracter;
    protected String colorEntitat;

    // Getters y setters
    public char getCharacter() {
        return caracter;
    }

    public String getColorEntitat() {
        return colorEntitat;
    }


    public void setCharacter(char caracter) {
        this.caracter = caracter;
    }

    public void setColorEntitat(String colorEntitat) {
        this.colorEntitat = colorEntitat;
    }

}

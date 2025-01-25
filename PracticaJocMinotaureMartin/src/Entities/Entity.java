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

    public Entity(int x, int y, String character, String colorEntitat) {
        this.x = x;
        this.y = y;
        this.character = character;
        this.colorEntitat = colorEntitat;
    }

    // Atributs classe pare
    protected int x;
    protected int y;
    protected String character;
    protected String colorEntitat;

    // Getters y setters
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getCharacter() {
        return character;
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

    public void setCharacter(String character) {
        this.character = character;
    }

    public void setColorEntitat(String colorEntitat) {
        this.colorEntitat = colorEntitat;
    }

}

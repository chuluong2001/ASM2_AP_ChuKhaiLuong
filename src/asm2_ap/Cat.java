/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asm2_ap;

/**
 *
 * @author Admin
 */
public class Cat extends Pet {
    private boolean isIndoor;
    private String furColor;

    public Cat(int id, String name, int age, boolean isIndoor, String furColor) {
        super(id, name, age);
        this.isIndoor = isIndoor;
        this.furColor = furColor;
    }

    public boolean getIsIndoor() {
        return isIndoor;
    }

    public void setIsIndoor(boolean isIndoor) {
        this.isIndoor = isIndoor;
    }

    public String getFurColor() {
        return furColor;
    }

    public void setFurColor(String furColor) {
        this.furColor = furColor;
    }

    @Override
    public String toString() {
        return super.toString() + ", isIndoor=" + isIndoor + ", furColor=" + furColor;
    }
}



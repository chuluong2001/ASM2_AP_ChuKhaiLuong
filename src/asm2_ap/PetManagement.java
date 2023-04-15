/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asm2_ap;

/**
 *
 * @author Admin
 */
public class PetManagement {
    private Pet[] pets;
    private int numPets;

    public PetManagement(int maxNumPets) {
        pets = new Pet[maxNumPets];
        numPets = 0;
    }

    public boolean addPet(Pet pet) {
        if (numPets >= pets.length) {
            return false; // No space for more pets
        }
        for (int i = 0; i < numPets; i++) {
            if (pets[i].getId() == pet.getId()) {
                return false; // Pet ID already exists
            }
        }
        pets[numPets] = pet;
        numPets++;
        return true;
    }

    public boolean deletePet(int id) {
        int index = -1;
        for (int i = 0; i < numPets; i++) {
            if (pets[i].getId() == id) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return false; // Pet ID not found
        }
        for (int i = index; i < numPets - 1; i++) {
            pets[i] = pets[i + 1];
        }
        pets[numPets - 1] = null;
        numPets--;
        return true;
    }

    public boolean editPet(int id, String newName, int newAge) {
    for (int i = 0; i < pets.length; i++) {
        if (pets[i] != null && pets[i].getId() == id) {
            pets[i].setName(newName);
            pets[i].setAge(newAge);
            return true;
        }
    }
    return false;
}


    public Pet searchPet(int id) {
    for (Pet pet : pets) {
        if (pet != null && pet.getId() == id) {
            return pet;
//            System.out.println(pet.getId() + "\t" + pet.getName() + "\t" + pet.getAge());
        }
    }
    return null;
}

    public void display() {
    if (pets == null) {
        System.out.println("No pets found.");
        return;
    }

    System.out.println("ID\tName\tAge");
    for (Pet pet : pets) {
        if (pet == null) {
            continue;
        }
        System.out.println(pet.getId() + "\t" + pet.getName() + "\t" + pet.getAge());
    }
}


}


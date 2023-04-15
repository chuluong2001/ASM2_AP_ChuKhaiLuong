/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package asm2_ap;

/**
 *
 * @author Admin
 */
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        PetManagement petManagement = new PetManagement(10);
        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        while (running) {
            try {
            System.out.println("\n========= Pet Management System ==========");
            System.out.println("\nEnter an option:");
            System.out.println("1. Add a cat");
            System.out.println("2. Edit a cat");
            System.out.println("3. Delete a cat");
            System.out.println("4. Search for a cat");
            System.out.println("5. Display all cats");
            System.out.println("6. Exit");
            System.out.println("--------------------------------------------" );
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    addPet(petManagement, scanner);
                    break;
                case 2:
                    editPet(petManagement, scanner);
                    break;
                case 3:
                    deletePet(petManagement, scanner);
                    break;
                case 4:
                    searchPet(petManagement, scanner);
                    break;
                case 5:
                    displayPets(petManagement);
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("\nInvalid option.");
                    break;
            }
            } catch (Exception e) {
                System.out.println("\nAn error occurred: " + e.getMessage());
                scanner.nextLine(); // consume newline character
            }
        }
    }

    public static void addPet(PetManagement petManagement, Scanner scanner) {
    System.out.println("\n+__ Add a cat __+\n");
    System.out.println("Enter cat ID:");
    int id = 0;
    try {
        id = scanner.nextInt();
        scanner.nextLine(); // consume newline character
        System.out.println("Enter cat name:");
        String name = scanner.nextLine();
        System.out.println("Enter cat age:");
        int age = scanner.nextInt();
        Pet newPet = new Pet(id, name, age);
        if (petManagement.addPet(newPet)) {
            System.out.println("cat added.");
        } else {
            System.out.println("Unable to add pet. Pet ID already exists.");
        }
    } catch (Exception e) {
        System.out.println("An error occurred while adding pet. Please try again.");
        scanner.nextLine(); // consume newline character
    }
}

   public static void editPet(PetManagement petManagement, Scanner scanner) {
    System.out.println("\n+__ Edit a cat __+\n");
    System.out.println("Enter cat ID to edit:");
    int editId = scanner.nextInt();
    scanner.nextLine(); // consume newline character
    System.out.println("Enter new cat name:");
    String editName = scanner.nextLine();
    System.out.println("Enter new cat age:");
    int editAge = scanner.nextInt();
    scanner.nextLine(); // consume newline character
    try {
        if (petManagement.editPet(editId, editName, editAge)) {
            System.out.println("cat edited.");
        } else {
            System.out.println("Unable to edit pet. Pet ID does not exist.");
        }
    } catch (Exception e) {
        System.out.println("An error occurred while editing pet. Please try again.");
    }
}


    public static void deletePet(PetManagement petManagement, Scanner scanner) {
        System.out.println("\n+__ Delete a cat __+\n");
        System.out.println("Enter cat ID:");
        int deleteId = scanner.nextInt();
        boolean deletedPet = petManagement.deletePet(deleteId);
        if (deletedPet) {
            System.out.println("cat deleted.");
        } else {
            System.out.println("Unable to delete pet. Pet ID not found.");
        }
    }
    
    public static void searchPet(PetManagement petManagement, Scanner scanner){
         System.out.println("\n+__ Search for a cat __+\n");
                System.out.println("Enter cat ID to search:");
                int searchId = scanner.nextInt();
                Pet searchPet = petManagement.searchPet(searchId);
                if (searchPet != null) {
                    System.out.println(searchPet.getId() + "\t" + searchPet.getName() + "\t" + searchPet.getAge());
                } else {
                    System.out.println("cat not found.");
                }
    }
    
     public static void displayPets(PetManagement petManagement){
         System.out.println("\n+__ Display all cats __+\n");
                   System.out.println("\nAll cats:");
                   petManagement.display();
     }
}

/**
*@author Myanh Nguyen
*CIS 36B
*/

import java.io.IOException;
import java.util.Scanner;
import java.io.File;


public class Museum {

    public static void main(String[] args) {
        System.out.println("Museum App\n");
        ArtLibrary al = new ArtLibrary();
        Museum museum = new Museum();
        String choice = "";
        int index;
        Art art = null;
        try {
            Scanner input = new Scanner(new File("works_of_art.txt"));
            al.populateCatalogue(input);
            al.bubbleSort();
            input.close();
            input = new Scanner(System.in);

            while (!choice.equalsIgnoreCase("X")) {
                al.printMenu();
                choice = input.nextLine().trim();

                if (choice.equalsIgnoreCase("V")) { // View
                    //fill in here
                    al.bubbleSort();
                    al.printStock();

                } else if (choice.equalsIgnoreCase("A")) { // Insert
                    art = museum.makeArtWorkFull(input);
                    //fill in here
                    al.appendElement(art);
                    //call bubbleSort here
                    al.bubbleSort();

                } else if (choice.equalsIgnoreCase("R")) { // Remove
                    System.out.println("\nSelect one of the following:");
                    System.out.println("\n1. Remove by index");
                    System.out.println("2. Remove by artwork");
                    System.out.print("\nEnter your choice: ");
                    choice = input.nextLine();

                    if (choice.equals("1")) { // remove by index
                        try {
                            System.out.println("\nEnter the number besides the work of art to remove: \n");
                            al.printNames();
                            System.out.print("\nEnter your choice: ");
                            int number = Integer.parseInt(input.nextLine());
                            //fill in here
                            art = al.removeElement(number);
                            System.out.println("\n" + art.getName() + " by " 
                              + art.getArtist() + " has been removed\n");
                        } catch (IndexOutOfBoundsException exc) {
                            System.out.println(exc.getMessage());
                        }

                    } else if (choice.equals("2")) { // remove by artwork
                        art = museum.makeArtWorkPartial(input);
                        if (al.removeElement(art)) {
                            System.out.println("\n" + art.getName() + " by " + art.getArtist() 
                              + " has been removed\n");
                        } else {
                            System.out.println("\n" + art.getName() + " by " + art.getArtist() 
                              + " could not be removed\n");
                        }
                    }
                   } else if (choice.equalsIgnoreCase("F")) { // Find
                       art = museum.makeArtWorkPartial(input);
                       al.bubbleSort();
                       try {
                           int idx = al.binarySearch(art);
                           System.out.println(al.get(idx));
                       } catch (IndexOutOfBoundsException exp) {
                           System.out.println("\nSorry! We could not locate " + art.getName() 
                              + " by " + art.getArtist());
                       }

                } else if (choice.equalsIgnoreCase("U")) { // Update
                    art = museum.makeArtWorkFull(input);
                    System.out.println("\nEnter the number besides the work of art to replace: \n");
                    al.printNames();
                    System.out.print("\nEnter your choice: ");
                    index = Integer.parseInt(input.nextLine().trim());
                    try {
                        //fill in here
                        al.set(index, art);
                    } catch (IndexOutOfBoundsException exc) {
                        System.out.println(exc.getMessage());
                    }
                    //call bubbleSort here
                    al.bubbleSort();

                } else if (choice.equalsIgnoreCase("X")) { // Exit
                    input.close();
                    System.out.println("\n\nGoodbye!");
                } else {
                    System.out.println("\nInvalid menu option.\n");
                }
            }

        } catch (IOException exp) {
            System.out.println("Cannot open file works_of_art.txt.\n\nGoodbye!");
        }

    } // end main
    
    /**
     * Prompts for and creates a complete work of art
     * for insertion into the catalogue
     * @param input the Scanner for user input
     * @return a complete work of art
     */
    public Art makeArtWorkFull(Scanner input) {
        Art art;
        System.out.println("\nSelect one of the following:\n");
        System.out.println("1. Sculpture");
        System.out.println("2. Painting");
        System.out.print("\nEnter your choice: ");
        String choice = input.nextLine();

        System.out.println("\nEnter the art work's information below: ");
        System.out.print("\nName: ");
        String name = input.nextLine().trim();
        System.out.print("Artist's Name: ");
        String artist = input.nextLine().trim();
        System.out.print("Year: ");
        int year = Integer.parseInt(input.nextLine().trim());
        System.out.print("Medium: ");
        String medium = input.nextLine().trim();
        //no code here!
        if (choice.equals("1")) { // Sculpture
            //fill in here
            System.out.print("Is this sculpture of a person: ");
            boolean isHuman = Boolean.parseBoolean(input.nextLine().trim());
            art = new Sculpture(name, artist, year, medium, isHuman);

        } else { // Painting
            //fill in here
            art = new Painting(name, artist, year, medium);
        }
        return art;
    }
    
    /**
     * Prompts for and creates a partial work of art
     * for the purposes of searching the catalogue
     * @param input the Scanner for user input
     * @return a complete work of art
     */
    public Art makeArtWorkPartial(Scanner input) {
        Art art;
        System.out.println("\nSelect one of the following:\n");
        System.out.println("1. Sculpture");
        System.out.println("2. Painting");
        System.out.print("\nEnter your choice: ");
        String choice = input.nextLine();

        System.out.println("\nEnter the art work's information below: ");
        System.out.print("\nName: ");
        String name = input.nextLine();
        System.out.print("Artist's Name: ");
        String artist = input.nextLine();
        System.out.print("Year: ");
        int year = Integer.parseInt(input.nextLine());

        if (choice.equals("1")) { // Sculpture
            art = new Sculpture(name, artist, year, "", false);

        } else { // Painting
            art = new Painting(name, artist, year, "");
        }
        return art;
    }

}


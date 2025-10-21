/**
*@author Myanh Nguyen
*CIS 36B
*/

import java.io.IOException;
import java.util.Scanner;

public class ArtLibrary implements Catalogue<Art> { // update to inherit from Catalogue
   private Art[] artworks;
   private int numWorks = 0;
   private final int MAX_SIZE = 10;
   
   /**
   *default constructor
   */
   public ArtLibrary(){
      this.artworks = new Art[MAX_SIZE];
      this.numWorks = 0;
   }
   
   /**
   *constructor that set art array size
   *@param size   int size of array
   */
   public ArtLibrary(int size){
      this.artworks = new Art[size];
      this.numWorks = size;
   }
   
   /**
   *add 10 more spaces into the array
   *@param artworks  aray of artworks to be resized 
   *@return temp new resized array
   */
   public Art[] resize(Art[] artworks){
      Art[] temp = new Art[artworks.length + MAX_SIZE];
      for (int i = 0; i < artworks.length; i++){
         temp[i] = artworks[i];
      }
      return temp;
   }
   
   // Add other required methods here
   
   /**
     * Reads from a file and populates the catalogue
     * @param scnr the Scanner used to read in the data
     */
   public void populateCatalogue(Scanner scnr) throws IOException{
      while(scnr.hasNextLine()){
         Art art = null;
         String type = scnr.nextLine().trim();
         String name = scnr.nextLine().trim();         
         String artist = scnr.nextLine().trim();         
         int year = Integer.parseInt(scnr.nextLine().trim());         
         String medium = scnr.nextLine().trim();
         
         if(type.equals("Sculpture")){
            boolean human = Boolean.parseBoolean(scnr.nextLine().trim());
            art = new Sculpture(name, artist, year, medium, human);        
         }
         else if (type.equals("Painting")) {
            art = new Painting(name, artist, year, medium);
         }
         artworks[numWorks] = art;
         numWorks++;
      }
      
   }
   
    /**
     * Searches for an element in the catalogue
     * @param art the element to locate
     * @return the location of the element in
     * the catalogue
     */
   public int binarySearch(Art art){
      int high = numWorks - 1;
      int low = 0;
      int mid;
      while(high >= low){
         mid = (high + low) / 2;
         if (artworks[mid].equals(art)){
            return mid;
         }
         else if (art.compareTo(artworks[mid]) < 0){
            high = mid - 1;
         }
         else{
            low = mid + 1;
         }
      }
      return -1;
   }
   
    /**
     * Sorts the catalogue into
     * ascending order using the
     * bubble sort algorithm
     */
   public void bubbleSort(){
      for (int i = 0; i < numWorks - 1; i++){
         for (int j = 0; j < numWorks - 1 - i; j++){
            if(artworks[j].compareTo(artworks[j + 1]) > 0){
               Art temp = artworks[j];
               artworks[j] = artworks[j + 1];
               artworks[j + 1] = temp;
            }
         }
      }
   }
   
    /**
     * Prints a menu of options to interact
     * with the catalogue
     */
   public void printMenu(){
      System.out.println("Please select from one of the options:");
      System.out.println("\nV. View Entire Catalogue");
      System.out.println("A. Add a New Work");
      System.out.println("R. Remove a Work");
      System.out.println("F. Find a Work of Art");
      System.out.println("U. Update a Work of Art");
      System.out.println("X. Exit");
      System.out.println("\nEnter your choice: ");
   }
   
    /**
     * Prints out the current catalogue
     */
   public void printStock(){
      System.out.println("Our Catalogue:");
      for (int i = 0; i < numWorks; i++){
         System.out.println(artworks[i] + "\n");
      }
   }
    
    /**
     * Prints out the names of the stock
     * in the catalogue in a numerical list
     */
   public void printNames(){
      for (int i = 0; i < numWorks; i++){
         System.out.println(i + ". " + artworks[i].getName() + " by " + artworks[i].getArtist());
      }
   }
    
    /**
     * Inserts an element at the end of the catalogue
     * @param art the new element to insert
     */
     
   public void appendElement(Art art){
      if (numWorks >= artworks.length){
         artworks = resize(artworks);
      }
      artworks[numWorks] = art;
      numWorks++;
   }
    
    /**
     * Removes an element from the catalogue
     * @param art the element to remove
     * @return whether the element was in the catalogue
     * and was successfully removed
     */
   public boolean removeElement(Art art){
      int idx = binarySearch(art);
      
      if (idx > 0){
         for (int i = idx; i < numWorks - 1; i++){
            artworks[i] = artworks[i + 1];
         }
         artworks[numWorks - 1] = null;
         numWorks--;
         return true;
      }
      else{
         return false;
      }
   }
    
    /**
     * Removes an element from the catalogue
     * @param index the location of the element in the catalogue
     * @throws IndexOutOfBoundsException when the index < 0 
     * or index >= numElements
     * @return the removed element
     */
   public Art removeElement(int index) throws IndexOutOfBoundsException{
      Art removed;
      if(index < 0 || index > numWorks){
         throw new IndexOutOfBoundsException("\nCould not remove the artwork at index "
            + index + ".\nPlease try again.\n");
      }
      else {
         removed = artworks[index];
         for (int i = index; i < numWorks - 1; i++){
            artworks[i] = artworks[i + 1];
         }
         artworks[numWorks - 1] = null;
         numWorks--;
      }
      return removed; 
   }
    
    /**
     * Access the element at the specified index in 
     * the catalogue
     * @param index the index of the desired element
     * @return the element at the specified index
     * @throws IndexOutOfBoundsException for an invalid index
     */
   public Art get(int index) throws IndexOutOfBoundsException{
      if(index < 0 || index >= numWorks){
         throw new IndexOutOfBoundsException("\nCould not access the artwork at index "
            + index + ".\nPlease try again.\n");
      }
      else {
         return artworks[index];
      }
   }
    
    /**
     * Updates the element at a specified index
     * to be a new element
     * @param index the index to update
     * @param element the new element to replace the
     * existing element at the index
     * @throws IndexOutOfBoundsException for an invalid index
     */
   public void set(int index, Art art) throws IndexOutOfBoundsException{
      if(index < 0 || index >= numWorks){
         throw new IndexOutOfBoundsException("\nCould not update the artwork at index "
            + index + ".\nPlease try again.\n");
      }
      else{
         artworks[index] = art;
      }
      
   }
     
}

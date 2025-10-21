/**
*@author Myanh Nguyen
*CIS 36B
*/

public class Painting extends Art{ //update to inherit from Art
   private String medium;
   
   /**
   * default contructor or painting
   */
   public Painting(){
      this("No name" , "No artist",  -1, "No medium");
   }
   
   /**
   *painting contructor 
   *@param name    new name for painting
   *@param artist  new artist name for painting
   *@param year    new year for year for painting
   *@param medium  new medium name for painting
   */
   public Painting(String name, String artist, int year, String medium){
      super(name, artist, year);
      this.medium = medium;
   }
   
   //SETTER
   
   /**
   *set new name 
   *@param medium    new medium for painting
   */
   public void setMedium(String medium){
      this.medium = medium;
   }
   
   //GETTER
   
   /**
   *get name
   *@return medium   medium for painting
   */
   public String getMedium(){
      return medium;
   }
   
   //COPY
   /**
   *create a copy of paiting
   *@param painting  the painting obj to copy
   */
   public Painting(Painting painting){
      this();
      if (painting != null){
         this.setName(painting.getName());
         this.setArtist(painting.getArtist());
         this.setYear(painting.getYear());
         this.medium = painting.medium;
      }
   }
   
   /**
   *print out painting data
   *@return a string of painting's info
   */
   @Override public String toString(){
      return super.toString() + "\n   Medium: " + medium;
   }

}
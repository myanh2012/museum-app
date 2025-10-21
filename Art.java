/**
*@author Myanh Nguyen
*CIS 36B
*/

public abstract class Art implements Comparable<Art>{
   private String name;
   private String artist;
   private int year;
   
   /**
   *default constructor 
   *create new art with no name, no artist, year -1
   */
   public Art (){
      this("No name", "No aritsit", -1);
   }
   
   /**
   *default constructor 
   *@param name      new name
   *@param artist    new artist 
   *@param year      new year
   */
   public Art(String name, String artist, int year){
      this.name = name;
      this.artist = artist;
      this.year = year;
   }
   
   // SETTERS  
   
   /**
   *set new name for art
   *@param name new name
   */
   public void setName(String name){
      this.name = name;
   }
   
   /**
   *set new artist for art
   *@param artist new name
   */
   public void setArtist(String artist){
      this.artist = artist;
   }
   
   /**
   *set new year for art
   *@param year new year
   */
   public void setYear(int year){
      this.year = year;
   }
   
   // SETTER 
   
   /**
   *get name for art
   *@return name 
   */
   public String getName(){
      return name;
   }
   
   /**
   *set artist for art
   *@return artist 
   */
   public String getArtist(){
      return artist;
   }
   
   /**
   *set year for art
   *@return year 
   */
   public int getYear(){
      return year;
   }
   
   //COPY 
   /**
   *ceate the new copy of art
   *@param art another Art to copy 
   */
   public Art(Art art){
      this();
      if (art != null){
         art.name = this.name;
         art.artist = this.artist;
         art.year = this. year;
      }
   }
   
   //EQUALS 
   /**
   *return if the two classes are the same
   *@param obj  another object to compare to
   *@return true if equals, false if not
   */
   @Override public boolean equals(Object obj){
      if (obj == this){
         return true;
      }
      else if (!(obj instanceof Art)){
         return false;
      }
      else {
         Art art = (Art) obj;
         return name.equals(art.name) && artist.equals(art.artist)
            && year == art.year;
      }
   }
   
   //COMPARE TO
   /**
   *compare the 2 objects alphabetically
   *@param art  object to compare
   *@return -1 if before, 1 is after and 0 if the same
   */
   @Override public int compareTo(Art art){
      if (this.equals(art)){
         return 0;
      }
      else if (!artist.equals(art.artist)){
         return artist.compareTo(art.artist);
      }
      else if (!name.equals(art.name)){
         return name.compareTo(art.name);
      }
      else {
         return Integer.compare(year, art.year);
      }
   }
   
   /**
   *print out a string type of Art
   *@return information about art
   */
   @Override public String toString(){
      return  "\nArtist: " + artist + "\n   Name: " + name + "\n   Year: " + year;
   }
   
}
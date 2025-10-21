/**
*@author Myanh Nguyen
*CIS 36B
*/

public class Sculpture extends Painting{ //update to inherit from Painting
   private boolean humanForm;
   
   /**
   * default contructor or Sculpture
   */
   public Sculpture(){
      this("No name" , "No artist",  -1, "No medium", false);
   }
   
   /**
   *Sculpture contructor 
   *@param name    new name for painting
   *@param artist  new artist name for painting
   *@param year    new year for year for painting
   *@param medium  new medium name for painting
   *@param humanForm    whether the sculture has human form
   */
   public Sculpture(String name, String artist, int year, String medium, boolean humanForm ){
      super( name, artist, year, medium);
      this.humanForm = humanForm;
   }
   
   // SETTER
   
   /**
   *set new humanForm 
   *@param humanForm    new humanForm for Sculpture
   */
   public void setHumanForm(boolean humanForm){
      this.humanForm = humanForm;
   }
   
   // GETTER
   
   /**
   *get humanForm 
   *@return humanForm  humanForm for Sculpture
   */
   public boolean getHumanForm(){
      return humanForm;
   }
   
   //COPY
   /**
   *create a copy of sculpture
   *@param sculpture a sculpture to copy
   */
   public Sculpture(Sculpture sculpture){
      this();
      if (sculpture != null){
         this.setName(sculpture.getName());
         this.setArtist(sculpture.getArtist());
         this.setYear(sculpture.getYear());
         this.setMedium(sculpture.getMedium());
         humanForm = sculpture.humanForm;
      }
   }
   
   //TO STRING
   /**
   *print data of sculpture
   *@return a string form of sculpture
   */
   @Override public String toString(){
      return super.toString() + "\n   Human Form: " + humanForm;
   }
}

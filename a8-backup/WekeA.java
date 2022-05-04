import java.util.Random;
/**
* Weke'a's object class.
* This is the fourth and final phase of Weke'a life
* It is strictly female
* The size is 16 inches and up
* @author Sean Sunoo
* @version 1.0
* @since 2/24/22
*/
public class WekeA extends Oama {
   
   // Constant instance variables, only add if changed from superclass
  
    /** constant array of what the fish eats. */
   protected static final String[] DIETITEMS = {"worms", "mollusks", "invertebrates"};
   /** constant maximum length for this Ia. 
   * Private because not inherited.
   */
   private static final double WEKE_A_MAX_LENGTH = 30.0;
   /** constant minimum length for this Ia. 
   * Private because not inherited.
   */
   private static final double WEKE_A_MIN_LENGTH = 7.0;
    /** constant english name for this Ia. 
   * Private because not inherited.
   */
   private static final String ENGLISH_NAME = "Square-spot Goatfish";
    /** constant scientific name for this Ia. 
   * Private because not inherited.
   */
   private static final String SCIENTIFIC_NAME = "Mulloidichthys flavolineatus";
   
 
   /**
   * Constructor for making Weke'a with random length 
   * uses I_a superclass constructor
   * uses dietItems array from super class
   * randomly sets length within allowed values after calling constructor.
   * This is the fourth phase of the species and always female
   * @throws FishSizeException if length is less than minLength
   * Must send minLength through as a temp length or throws exception
   */
   //"Square-spot Goatfish", "Mulloidichthys flavolineatus",
   public WekeA() {
      super("Weke'a", ENGLISH_NAME, SCIENTIFIC_NAME, WEKE_A_MAX_LENGTH, 
      WEKE_A_MIN_LENGTH, WEKE_A_MIN_LENGTH, (WEKE_A_MIN_LENGTH * 2), DIETITEMS,  
         "white with yellow stripe and black spot", 
         "white", "male or female"); 
      //method is in superclass but will use max, min length set above
      this.initLength();  
      this.initSex();
   }
   
   /**
   * Constructor for making Weke'a with a given length 
   * uses I_a superclass constructor
   * uses dietItems array from super class
   * randomly sets length within allowed values after calling constructor.
   * This is the fourth phase of the species and always female.
   *@param length This fish's size.
   * @throws FishSizeException if length is less than minLength
   */
   public WekeA(double length) {
      super("Weke'a", ENGLISH_NAME, SCIENTIFIC_NAME, WEKE_A_MAX_LENGTH, 
      WEKE_A_MIN_LENGTH, length, (length * 2), DIETITEMS,  
      "white with yellow stripe and black spot", "white", "male or female");
      this.initSex(); 

   }
   
   //Weke'a do not change to another type, so we overwrite the grow method from the base class.
   /**
   * Should be used by eat method to increase length of fish. 
   * Should determine a new length and internally call setLength
   * Does not throw FishSizeException because this is the final type of this fish
   */
   protected void grow() {
      Random ran = new Random();
      double lengthIncrease = ran.nextDouble() * growthRate;

      //calculate a new length by adding a random value between 0 and growthRate
      this.length = this.length + lengthIncrease;
      this.weight = this.length * 2;
   }
    
   /** returns the same fish
   * Weke'a don't level up, this is the terminal type.
   * method is required but shouldn't do anything
   *@return Returns this fish because it cannot level up
   */
   public WekeA levelUp() {
      return this;
     
   
   }
   
    //============== required by SexChangable interface ===============================
   
   /** 
   * changes this Weke'a's s sex.
   * Weke'a cannot change sex within their size group
   */
   public void changeSex() {
      throw new UnsupportedOperationException("Weke'a cannot change sex.");
   }
   
   /**
   * returns the reproductive mode of this sex changing fish.
   *@return returns the reproductive method
   */
   public String getReproductiveMode() {
      return REPRODUCTIVEMODE;
   }
   
    /** 
   * determines if the fish can dynamically change colors.
   *@param newBodyColor the color that the Ia's body will change to
   *@param newFinColor the color that the Ia's fin will change to
   */
    
   public void setColor(String newBodyColor, String newFinColor) {
      this.finColor = newBodyColor;
      this.bodyColor = newFinColor;
      return;
   }
   
      //============= Required by Fishable ==================
   /** 
   * determines if the fish is legal to keep due to length.
   * @return true If this fish is legal size to keep.
   */
   public boolean isLegalSize() {
      return true; //No minimum legal size
   }
   
   /**
   * determines if this fish can be used as a baitfish.
   * @return true if this fish type is used for bait for other fishing.
   */
   public boolean isBait() {
      return true;
   }
   
   /**
   * determines if this fish can be used to eat.
   * @return true if this fish is edible, and allowed to be eaten.
   */
   public boolean isGamefish() {
      return true;
   }
   
      /**
   * Always in season.
   * @param month the current month of the year.
   * @return true if fish is okay to take, false otherwise.
   */
   public boolean isInSeason(String month) {
     return true;
   }
   /**
   * Returns the methods of catching this fish.
   * @return an array of fishing methods.
   */
   public String[] getCatchMethods() {
       return new String[] {"net", "pole"};
   }
   
     /**
   * Returns the limit on number of Moi you're allowed to catch.
   * @return int representing the maximum number of Moi you are allowed.
   */
   public int getBagLimit() {
      return 50;
   }   
  
}
   
   

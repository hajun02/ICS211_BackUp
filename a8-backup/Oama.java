import java.util.Random;
/**
*Oama's fish object class.
*Smallest version of the Weke fish
*Parent class to the Weke_a and Weke_ula
*@author Sean Sunoo
*@version 1.0
*@since 2/24/22
*/

public class Oama extends FishableI_a implements SexChangeable, ColorChangeable {
   
   //Constants for this fish.
   // protected will be inherited by subclasses unless replaced
   /** constant array of what the fish eats. */
   protected static final String[] DIETITEMS = {"worms", "mollusks", "invertebrates"};
   /** constant reproductive mode for this Ia. */
   protected static final String REPRODUCTIVEMODE = "serial";
   
   /** constnat maximum length for this Ia
   * Private because not inherited.
   */
   private static final double OAMA_MAX_LENGTH = 7.0;
   /** constant minimum length for this Ia.
   * Private because not inherited
   */
   private static final double OAMA_MIN_LENGTH = 0.0;
    /** constant english name for this Ia. 
   * Private because not inherited.
   */
   private static final String ENGLISH_NAME = "Goatfish";
    /** constant scientific name for this Ia. 
   * Private because not inherited.
   */
   private static final String SCIENTIFIC_NAME = "Mulloidichthys";
   
   /**
   * Constructor for making Weke
   * uses I_a superclass constructor
   * randomly sets length within allowed values after calling constructor.
   * This is the juvenile of the species and has no sex detemination.
   */
   public Oama() {
    super("'Oama", ENGLISH_NAME, SCIENTIFIC_NAME, OAMA_MAX_LENGTH, OAMA_MIN_LENGTH, 0.1, 2.0,
         DIETITEMS, "white with yellow stripe", "yellow or white", "none");

      //set random allowed length after
      this.initLength();
   }

 /**
   * Constructor for making oama with a specific length.
   * uses I_a superclass constructor
   *@param length This fish's size.
   *@throws FishSizeException if length exceeds maxLength or is less than minLength
   * @throws FishSizeException if length is larger than maxLength or smaller than minLength.
   * This is the juvinile of the species and has no sex determination.
   */
   public Oama(double length) {
   super("'Oama", ENGLISH_NAME, SCIENTIFIC_NAME, OAMA_MAX_LENGTH, OAMA_MIN_LENGTH, length, 
         (length * 2), DIETITEMS, "white with yellow stripe", "yellow or white", "none");

   }
 /** 
   * Protected constructor for subclasses.
   * This allows subclass specific variables  
   * to pass through to I'a superclass constructor.
   *
   *
   *@param name This fish type's Hawaiian name.
   *@param maxLength The maximum length this name applies.
   *@param minLength The minimum length this name applies.
   *@param length This fish's size.
   *@param weight This fish's weight.
   *@param diet The diet preference of this fish type.
   *@param bodyColor The body color of this fish.
   *@param finColor The fin color of this fish.
   *@param sex The sex of this fish.
   *@param scientificName the scientific name for the fish
   *@param englishName the scientific name for the fish
   *@throws FishSizeException if length exceeds maxLength or is less than minLength
   */
   protected Oama(String name, String englishName, String scientificName, double maxLength, 
       double minLength, double length, double weight, String[] diet, String bodyColor, 
       String finColor, String sex) {
      
      super(name, englishName, scientificName, maxLength, minLength, 
         length, weight, diet, bodyColor, finColor, "N/A");
   }

 
   /**
   * Sets the fish's initial length to between its max and min allowed values.
   */
   protected void initLength() {
      Random ran = new Random();
      this.length = this.minLength + (this.maxLength - this.minLength) * ran.nextDouble();
      this.weight = this.length * 2;
   }

//++++++++++++++++ Superclass required implementations of abstract methods ++++++++++
   
   /**
   * Sets the fish's length to newLength.
   *@param newLength The new length of the fish
   * @throws FishSizeException if the new length is not within min-max length for type
   */
   public void setLength(double newLength) throws FishSizeException {  
      if (newLength >= this.minLength && newLength < this.maxLength) {
         this.length = newLength;
      } else {
         throw new FishSizeException(this.name + " must be within " + this.minLength 
               + " and " + this.maxLength + " inches long.");
      } 
   
   
   }
 /**
   * Sets the fish's weight to newWeight.
   *@param newWeight The new weight of the fish
   */
   public void setWeight(double newWeight) {  
      
      this.weight = newWeight;
   
   }
   

 /**
   * Models eating, should call grow to cause length increases.
   * @param food A String with a potential food name
   * @throws FishFoodException if the food is not the fish's diet
   */
   public void eat(String food) {
      Random ran = new Random();
      boolean isEdible = false;
      //loop through what fish eats and determine if edible
      for (int i = 0; i < DIETITEMS.length; i++) {
         if (food.equals(DIETITEMS[i])) {
            isEdible = true;
         }
      }
      if (isEdible) {
         this.grow();
      } else {
         throw new FishFoodException(this.name + " does not eat " + food);
      }
   }

   /**
   * Should be used by eat method to increase length of fish. 
   * Should determine a new length and internally call setLength
   * @throws FishSizeException if the new length is not within min-max length for type
   *  indicates levelUp needs to be called.
   */
   protected void grow() {
      Random ran = new Random();
      double lengthIncrease = ran.nextDouble() * growthRate;
   
      //calculate a new length by adding a random value between 0 and growthRate
      double newLen = this.length + lengthIncrease;
   
      //check to see if this fish needs to level up
      if (newLen > this.maxLength) {
         throw new FishSizeException("This fish has outgrown its name, it must level up!");
      } else {
         this.length = newLen;
         this.weight = 2 * newLen; //rudimentary weight calc
      }
   }
   
   
 /** returns new Weke_a or Weke_Ula version of this fish.
   * When a Oama reaches maxLength, it should levelUp to a Weke_a or Weke_Ula of  min length
   * min size of next size is always max length of this one
   * @return a new Weke_a or Weke_ula
   */
  
     
   public Oama levelUp() {
      Random ran = new Random();
      int i = 0;
      int range = 2;
      i = ran.nextInt(range);
      if (i == 1) {
         return new WekeA(this.maxLength);
      } else {
         return new WekeUla(this.maxLength);
      }   
  
 
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
   

   
   //============== required by SexChangable interface ===============================
   
   /** 
   * changes this Oama's sex
   * Oama cannot change sex within their size group. Can only change at levelUp
   */
   public void changeSex() {
      throw new UnsupportedOperationException("Oama cannot change sex.");
   }
   
   /**
   * returns the reproductive mode of this sex changing fish.
   *@return returns the reproductive method
   */
   public String getReproductiveMode() {
      return REPRODUCTIVEMODE;
   }
  
  
  
 //============= Required by ColorChangeable interface ==================
   /** 
   * determines if the fish can dynamically change colors.
   *@param newBodyColor the color that the Ia's body will change to
   *@param newFinColor the color that the Ia's fin will change to
   */
  

   public void setColor(String newBodyColor, String newFinColor) {
      System.out.println("Oama cannot change their color");
      return;
   }



} //ends oama
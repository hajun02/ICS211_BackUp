import java.util.Random;
/**
* Pua'ama fish object class.
* Smallest type version of Anae fish
* Parent class to Kahaha
* @author Dylan Elies
* @version 1.0
* @since 2/27/22
*/

public class Pua_ama extends FishableI_a {

   // Constants for this fish.
   // protected will be inherited by subclasses unless replaced
   /** constant array of what the fish eats. */
   protected static final String[] DIETITEMS = {"zooplankton", "algae", "detritus", "invertebrates"};

   /** constant maximum length for this Ia. 
   * Private because not inherited.
   */
   private static final double PUAAMAMAXLENGTH = 4.0;
   /** constant minimum length for this Ia. 
   * Private because not inherited.
   */
   private static final double PUAAMAMINLENGTH = 0.0;
   
   /**
   * Constructor for making Pua'ama.
   * uses I_a superclass constructor.
   * randomly sets length within allowed values after calling constructor.
   * This is the juvenile of the species and has no sex determination.
   */
   public Pua_ama() {
      super("Pua'ama", "Striped Mullet", "Mugil cephalus", PUAAMAMAXLENGTH,
         PUAAMAMINLENGTH, 0.1, 2.0, DIETITEMS, "silver", "silver", "none");   
      //set random allowed length after
      this.initLength();
   }
   
   /**
   * Constructor for making Pua'ama with a specific length.
   * uses I_a superclass constructor.
   * @throws FishSizeException if length is larger than maxLength or smaller than minLength.
   * This is the juvinile of the species and has no sex determination.
   * @param length The length of this fish.
   */
   public Pua_ama(double length) {
      super("Pua'ama", "Striped Mullet", "Mugil cephalus", PUAAMAMAXLENGTH,
         PUAAMAMINLENGTH, length, (length * 2), DIETITEMS, "silver", "silver", "none");   
   }
   
   /** 
   * Protected constructor for subclasses.
   * This allows subclass specific variables  
   * to pass through to I'a superclass constructor.
   *
   * In this species, the English and scientific names
   * remain the same throughout so not needed to pass from subclasses.
   *
   *@param name This fish type's Hawaiian name.
   *@param maxLength The maximum length this name applies.
   *@param minLength The minimum length this name applies.
   *@param length This fish's size.
   *@param diet The diet preference of this fish type.
   *@param bodyColor The body color of this fish.
   *@param finColor The fin color of this fish.
   *@param sex The sex of this fish.
   *@param weight The weight of this fish.
   *@throws FishSizeException if length exceeds maxLength or is less than minLength
   */
   protected Pua_ama(String name, double maxLength, double minLength, 
         double length, double weight, String[] diet, String bodyColor, 
            String finColor, String sex) {
       
      super(name, "Striped Mullet", "Mugil cephalus", maxLength, minLength, 
         length, weight, diet, bodyColor, finColor, sex);
         
   }
   
   /**
   * Sets the fish's initial length to between its max and min allowed values.
   */
   protected void initLength() {
      Random rand = new Random();
      this.length = this.minLength + (this.maxLength - this.minLength) * rand.nextDouble();
      this.weight = this.length * 2;
   }
   
   //++++++++++++++++ Superclass required implementations of abstract methods ++++++++++
   
   /**
   * Sets the fish's length.
   * @param nLength new length to set to
   * @throws FishSizeException if nLength is not between max and min lengths
   */
   public void setLength(double nLength) throws FishSizeException {
      if (nLength >= this.minLength && nLength < this.maxLength) {
         this.length = nLength;
      } else {
         throw new FishSizeException(this.name + " must be within " + this.minLength 
               + " and " + this.maxLength + " inches long.");
      } 
   }
   
   /**
   * Sets the fish's weight.
   * @param nWeight new weight to set to
   */
   public void setWeight(double nWeight) {
      this.weight = nWeight;
   }
   
   /**
   * Models eating, should call grow to cause length increases.
   * @param food A String with a potential food name
   * @throws FishFoodException if the food is not the fish's diet
   */
   public void eat(String food) throws FishFoodException {
      boolean isEdible = false;
      //loop through what fish eats and determine if edible
      for (int i = 0; i < DIETITEMS.length; i++) {
         if (food.equalsIgnoreCase(DIETITEMS[i])) {
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
   
   /** returns Kahaha version of this fish.
   * When a Pua'ama reaches maxLength, it should levelUp to a Kahaha of  min length
   * min size of next size is always max length of this one
   * @return a new Kahaha
   */  
   public Kahaha levelUp() {
      return new Kahaha(this.maxLength);
   }
   
   //============= Required by Fishable ==================
   /** 
   * determines if the fish is legal to keep due to length.
   * @return true If this fish is legal size to keep.
   */
   public boolean isLegalSize() {
          if (this.length >= 11) {
         return true;
      } 
      return false;
   }
   
   /**
   * determines if this fish can be used as a baitfish.
   * @return true if this fish type is used for bait for other fishing.
   */
   public boolean isBait() {
      return false; //Not bait
   }
   
   /**
   * determines if this fish can be used to eat.
   * @return true if this fish is edible, and allowed to be eaten.
   */
   public boolean isGamefish() {
          if (this.length >= 11) {
         return true;
      } 
      return false;
   }
   
     /**
   * Pua_ama season is April-November. No catching December-March
   * @param month the current month of the year.
   * @return true if fish is okay to take, false otherwise.
   */
   public boolean isInSeason(String month) {
      month = month.toLowerCase();
      boolean isOk = true;
      
      switch(month) {
         case "december":
         case "january":
         case "february":
         case "march":
            isOk = false;
            break;
         default:
            isOk = true;
            break;
      }
      return isOk;
   }
   
   /**
   * Returns the methods of catching this fish.
   * @return an array of fishing methods.
   */
   public String[] getCatchMethods() {
      return new String[] {"net", "pole"};
   }
   
      /**
   * Returns the limit on number of Pua_ama you're allowed to catch.
   * @return int representing the maximum number of Moi you are allowed.
   */
   public int getBagLimit() {
      return Integer.MAX_VALUE;
   }  
   
}

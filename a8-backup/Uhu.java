import java.util.Random;
/**
* Uhu's object class.
* This is the final phase of Uhu life
* It is female, male, or supramale
* The size is 12 inches and up
* @author Michelle Back
* @version 1.0
* @since 2/25/22
*/
public class Uhu extends Panuhunuhu {
   
   // Constant instance variables, only add if changed from superclass

   /** constant maximum length for this Ia.
   * This is the state record 
   * Private because not inherited.
   */
   private static final double UHUMAXLENGTH = 30.0;
   /** constant minimum length for this Ia. 
   * Private because not inherited.
   */
   private static final double UHUMINLENGTH = 12.0;
   /** constant scientific name for this fish.
   * Private because not inherited.
   */
   private static final String SCIENTIFICNAME = "Scarus psittacus";
   
 
   /**
   * Constructor for making Uhu with random length 
   * uses I_a superclass constructor
   * uses dietItems array from super class
   * randomly sets length within allowed values after calling constructor.
   * This is the third phase of the species.
   * @throws FishSizeException if length is less than minLength
   * Must send minLength through as a temp length or throws exception
   */
   public Uhu() {
      super("Uhu", SCIENTIFICNAME, UHUMAXLENGTH, UHUMINLENGTH, 
         UHUMINLENGTH, (UHUMINLENGTH * 2), DIETITEMS, "",
            "gray or reddish gray or blue", "male or female or supermale"); 
      //method is in superclass but will use max, min length set above
      this.initLength();
      this.initSex(); 
      this.initColor();
   }
   
   /**
   * Constructor for making Uhu with a given length 
   * uses I_a superclass constructor
   * uses dietItems array from super class
   * randomly sets length within allowed values after calling constructor.
   * This is the third phase
   * @param length the fish's size.
   * @throws FishSizeException if length is less than minLength
   */
   public Uhu(double length) {
      super("Uhu", SCIENTIFICNAME, UHUMAXLENGTH, UHUMINLENGTH, 
         length, (length * 2), DIETITEMS, "",
            "gray or reddish gray or blue", "male or female or supermale");
      this.initSex(); 
      this.initColor();

   }
   
   /**
   * Sets the fish's gender to male or female or supermale.
   */
   protected void initSex() {
      Random ran = new Random();
      int flip = ran.nextInt(2);
      if (flip == 0) {
         this.sex = "female";
         this.sex = "supermale";
      } else {
         this.sex = "male";
      }
   }
   
    /**
   * Sets the fish's fin color randomly.
   * @paramc fish's body color
   */
   protected void initColor() {
      Random ran = new Random();
      int flip = ran.nextInt(2);
      if (flip == 0) {
         this.finColor = "gray";
      } else {
         this.finColor = "reddish gray";
      }
      if (sex.equals("supermale")) {
         this.bodyColor = "blue-green";
         this.finColor = "blue";
      } else {
         this.bodyColor = "gray";
      }
   }

      
   
   //Moi do not change to another type, so we overwrite the grow method from the base class.
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
   * Uhu don't level up, this is the terminal type.
   * method is required but shouldn't do anything
   * @return this final evolution of the Uhu family
   */
   public Uhu levelUp() {
   
      return this;
   
   }

      //============= Required by Fishable ==================
   /** 
   * determines if the fish is legal to keep due to length.
   * @return true If this fish is legal size to keep.
   */
   public boolean isLegalSize() {
          if (this.length >= 12) { //Legal size is 12 inches and above
         return true;
      } 
      return false;
   }
   
   /**
   * determines if this fish can be used as a baitfish.
   * @return true if this fish type is used for bait for other fishing.
   */
   public boolean isBait() {
      return false; //not baitfish
   }
   
   /**
   * determines if this fish can be used to eat.
   * @return true if this fish is edible, and allowed to be eaten.
   */
   public boolean isGamefish() {
      if (this.length >= 12) { //Legal size is 12 inches and above
         return true;
      } 
      return false;
   }
   
   /**
   * Returns the methods of catching this fish.
   * @return an array of fishing methods.
   */
   public String[] getCatchMethods() {
      return new String[] {"throw net", "spear", "pole"};
   }
   
     /**
   * Fish is always in season.
   * @param month the current month of the year.
   * @return true if fish is okay to take, false otherwise.
   */
   public boolean isInSeason(String month) {
      return true; //season is always open
   }
   
     /**
   * Returns the limit on number of Moi you're allowed to catch.
   * @return int representing the maximum number of Moi you are allowed.
   */
   public int getBagLimit() {
      return Integer.MAX_VALUE;
   }  
    

}  
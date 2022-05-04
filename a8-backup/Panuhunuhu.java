import java.util.Random;
/**
* Panuhunuhu's object class.
* This is the second phase of Uhu life
* Male or Female
* The size is 4 - 12 inches
* @author Michelle Back
* @version 1.0
* @since 2/25/22
*/
public class Panuhunuhu extends Ohua {
   
   // Constant instance variables, only add if changed from superclass

   /** constant maximum length for this Ia. 
   * Private because not inherited.
   */
   private static final double PANUHUNUHUMAXLENGTH = 12.0;
   /** constant minimum length for this Ia. 
   * Private because not inherited.
   */
   private static final double PANUHUNUHUMINLENGTH = 4.0;
   /** constant scientific name for this fish.
   * Private because not inherited.
   */
   private static final String SCIENTIFICNAME = "Scaridae";
   

   
 
   /**
   * Constructor for making Panuhunuhu with random length 
   * uses I_a superclass constructor
   * uses dietItems array from super class
   * randomly sets length within allowed values after calling constructor.
   * This is the second phase of the species and is male or female.
   * @throws FishSizeException if length exceeds maxLength or is less than minLength
   * Must send minLength  through as a temp length or throws exception
   */
   public Panuhunuhu() {
      super("Panuhunuhu", SCIENTIFICNAME, PANUHUNUHUMAXLENGTH, PANUHUNUHUMINLENGTH, 
         PANUHUNUHUMINLENGTH, (PANUHUNUHUMINLENGTH * 2), DIETITEMS, "gray", 
            "", ""); 
      //method is in superclass but will use max, min length set above
      this.initLength(); 
      this.initSex(); 
      this.initColor();
   }
   
   /**
   * Constructor for making Panuhunuhu with a given length 
   * uses I_a superclass constructor
   * uses dietItems array from super class
   * randomly sets length within allowed values after calling constructor.
   * This is the second phase of the species and is male or female.
   * @param length the fish's size
   * @throws FishSizeException if length exceeds maxLength or is less than minLength
   */
   public Panuhunuhu(double length) {
      super("Panuhunuhu", SCIENTIFICNAME, PANUHUNUHUMAXLENGTH, PANUHUNUHUMINLENGTH, 
         length, (length * 2), DIETITEMS, "gray", "", ""); 
      this.initSex(); 
      this.initColor();

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
   *@param scientificName the fish's scientific name.
   *@param maxLength The maximum length this name applies.
   *@param minLength The minimum length this name applies.
   *@param length This fish's size.
   *@param weight the fish's size.
   *@param diet The diet preference of this fish type.
   *@param bodyColor The body color of this fish.
   *@param finColor The fin color of this fish.
   *@param sex The sex of this fish.
   *@throws FishSizeException if length exceeds maxLength or is less than minLength
   */
   protected Panuhunuhu(String name, String scientificName, double maxLength, double minLength, 
         double length, double weight, String[] diet, 
                  String bodyColor, String finColor, String sex) {
       
      super(name, scientificName, maxLength, minLength, 
         length, weight, diet, bodyColor, finColor, sex);
   }
   
   
   

    /** returns new Uhu version of this fish.
   * When a Panuhunuhu reaches maxLength, it should levelUp to a Uhu of  min size
   * min size of next size is always max size of this one
   * @return a new Uhu
   */
   public Uhu levelUp() {
   
      return new Uhu(this.maxLength);
   
   }

//============= Required by Fishable ==================
//override smaller types because becomes legal at 11"
   /** 
   * determines if the fish is legal to keep due to length.
   * @return true If this fish is legal size to keep.
   */
   public boolean isLegalSize() {
      if (this.length >= 12) {
         return true;
      } else {
         return false;
      } 
   }
   
   /**
   * determines if this fish can be used as a baitfish.
   * @return true if this fish type is used for bait for other fishing.
   */
   public boolean isBait() {
      return false;
   }
   
   /**
   * determines if this fish can be used to eat.
   * @return true if this fish is edible, and allowed to be eaten.
   */
   public boolean isGamefish() {
      return false;
   }
   
   /**
   * Returns the methods of catching this fish.
   * @return an array of fishing methods.
   */
   public String[] getCatchMethods() {
      return null;
   }
   //============== required by SexChangable interface ===============================
   
   
   /**
   * returns the reproductive mode of this sex changing fish.
   *@return reproductiont type of fish.
   */
   public String getReproductiveMode() {
      return REPRODUCTIVEMODE;
   }
   //============== required by ColorChangeable interface ===============================
   
   /** 
   * changes this Panuhunuhu s fin color.
   * @param bodyColor changes the body color of the fish randomly.
   * @param finColor changes the fin color of the fish randomly.
   */
   public void setColor(String bodyColor, String finColor) {
      Random ran = new Random();
      int flip = ran.nextInt(2);
      if (flip == 0) {
         this.finColor = "gray";
      } else {
         this.finColor = "reddish gray";
      }
      if (sex.equals("supermale")) {
         this.bodyColor = "blue-green";
      } else {
         this.bodyColor = "gray";
      }
   }




}
   

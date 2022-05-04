import java.util.Random;
/**
* Kahaha's fish object class.
* Second smallest type version of Anae fish
* Parent class to Ama_ama
* @author Dylan Elies
* @version 1.0
* @since 2/27/22
*/

public class Kahaha extends Pua_ama {

   // Constant instance variables, only add if changed from superclass

   /** constant maximum length for this Ia. 
   * Private because not inherited.
   */
   private static final double KAHAHAMAXLENGTH = 8.0;
   /** constant minimum length for this Ia. 
   * Private because not inherited.
   */
   private static final double KAHAHAMINLENGTH = 4.0;
   
   /**
   * Constructor for making Kahaha.
   * uses I_a superclass constructor.
   * randomly sets length within allowed values after calling constructor.
   * randomly sets sex after calling constructor.
   */
   public Kahaha() {
      super("Kahaha", KAHAHAMAXLENGTH, KAHAHAMINLENGTH, KAHAHAMINLENGTH, (KAHAHAMINLENGTH*2), 
         DIETITEMS, "silver", "silver", "tbd");   
      //set random allowed length after
      this.initLength();
      //set random sex after
      this.initSex();
   }

   /**
   * Constructor for making Kahaha with a specific length.
   * uses I_a superclass constructor.
   * randomly sets sex after calling constructor.
   * @param length The length of the fish.
   */
   public Kahaha(double length) {
      super("Kahaha", KAHAHAMAXLENGTH, KAHAHAMINLENGTH, length, (length * 2), 
         DIETITEMS, "silver", "silver", "tbd"); 
      //set random sex after
      this.initSex();
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
   protected Kahaha(String name, double maxLength, double minLength, 
         double length, double weight, String[] diet, String bodyColor,
            String finColor, String sex) {
       
      super(name, maxLength, minLength, 
         length, weight, diet, bodyColor, finColor, sex);
   }
   /**
   * Randomly assigns a sex.
   */
   protected void initSex() {
      Random rand = new Random();
      int coin = rand.nextInt(2);
      if (coin == 0) {
         this.sex = "Male";
      } else {
         this.sex = "Female";
      }
   }

   /** returns new Ama_ama version of this fish.
   * When a Kahaha reaches maxLength, it should levelUp to a Ama_ama of  min size
   * min size of next size is always max size of this one
   * @return a new Ama_ama
   */
   public Ama_ama levelUp() {
   
      return new Ama_ama(this.maxLength);
   
   }
   //============= Required by Fishable ==================
   /** 
   * determines if the fish is legal to keep due to length.
   * @return true If this fish is legal size to keep.
   */
   public boolean isLegalSize() {
      return false; //idk where to find this :(
   }
   
   /**
   * determines if this fish can be used as a baitfish.
   * @return true if this fish type is used for bait for other fishing.
   */
   public boolean isBait() {
      return false; //idk where to find this
   }
   
   /**
   * determines if this fish can be used to eat.
   * @return true if this fish is edible, and allowed to be eaten.
   */
   public boolean isGamefish() {
      return false; //idk where to find this
   }
   
   /**
   * Returns the methods of catching this fish.
   * @return an array of fishing methods.
   */
   public String[] getCatchMethods() {
      return new String[] {"net"};
   }
   

}

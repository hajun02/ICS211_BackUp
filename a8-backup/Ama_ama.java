/**
* Ama_ama's fish object class.
* Second biggest type version of Anae fish
* Parent class to Anae
* @author Dylan Elies
* @version 1.0
* @since 2/27/22
*/

public class Ama_ama extends Kahaha {

   // Constant instance variables, only add if changed from superclass

   /** constant maximum length for this Ia. 
   * Private because not inherited.
   */
   private static final double AMAAMAMAXLENGTH = 12.0;
   /** constant minimum length for this Ia. 
   * Private because not inherited.
   */
   private static final double AMAAMAMINLENGTH = 8.0;
   
   /**
   * Constructor for making 'Ama'ama with random length.
   * uses I_a superclass constructor.
   * randomly sets length within allowed values after calling constructor.
   * randomly sets sex after calling constructor.
   */
   public Ama_ama() {
      super("'Ama'ama", AMAAMAMAXLENGTH, AMAAMAMINLENGTH, AMAAMAMINLENGTH, (AMAAMAMINLENGTH*2), 
         DIETITEMS, "silver", "silver", "tbd");   
      //set random allowed length after
      this.initLength();
      //set random sex after
      this.initSex();
   }

   /**
   * Constructor for making 'Ama'ama with a specific length.
   * uses I_a superclass constructor.
   * randomly sets sex after calling constructor.
   * @param length length of the fish
   */
   public Ama_ama(double length) {
      super("'Ama'ama", AMAAMAMAXLENGTH, AMAAMAMINLENGTH, length, (length * 2), 
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
   *@param weight The weight of the fish.
   *@throws FishSizeException if length exceeds maxLength or is less than minLength
   */
   protected Ama_ama(String name, double maxLength, double minLength, 
         double length, double weight, String[] diet, String bodyColor, 
            String finColor, String sex) {
       
      super(name, maxLength, minLength, 
         length, weight, diet, bodyColor, finColor, sex);
   }
   
   /** returns new Anae version of this fish.
   * When an Ama_ama reaches maxLength, it should levelUp to a Anae of  min size
   * min size of next size is always max size of this one
   * @return a new Anae
   */
   public Anae levelUp() {
   
      return new Anae(this.maxLength);
   
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

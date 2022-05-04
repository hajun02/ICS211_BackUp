/**
* Anae's fish object class.
* Anae fish
* @author Dylan Elies
* @version 1.0
* @since 2/27/22
*/

public class Anae extends Ama_ama {

   // Constant instance variables, only add if changed from superclass

   /** constant maximum length for this Ia. 
   * Private because not inherited.
   */
   private static final double ANAEMAXLENGTH = 27.0;
   /** constant minimum length for this Ia. 
   * Private because not inherited.
   */
   private static final double ANAEMINLENGTH = 12.0;
   
   /**
   * Constructor for making Anae with random length.
   * uses I_a superclass constructor.
   * randomly sets length within allowed values after calling constructor.
   * randomly sets sex after calling constructor.
   */
   public Anae() {
      super("'Anae", ANAEMAXLENGTH, ANAEMINLENGTH, ANAEMINLENGTH, (ANAEMINLENGTH*2), 
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
   public Anae(double length) {
      super("'Anae", ANAEMAXLENGTH, ANAEMINLENGTH, length, (length * 2), 
         DIETITEMS, "silver", "silver", "tbd"); 
      //set random sex after
      this.initSex();
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

/** 
 * Creates & displays an array of Strings.
 * @author Lisa Miller from W.Albritton
 * @since 1/29/2020 
 */
public class ArraysAndMethods {

   /**
    * The main method.
    * @param args not used 
    */
   public static void main(String[] args) {
      
      String[] stoogesNames = ArraysAndMethods.createStooges();
      
      System.out.println(stoogesNames[0] + " in main before");
      ArraysAndMethods.displayArray(stoogesNames);
      System.out.println(stoogesNames[0] + " in main after");
      
   }
   
   /**
    * creates & returns an array of strings.
    *
    * @return an array of the 3 Stooges names
    */    
   public static String[] createStooges() {
      // declare array and instatiate (create) array
      String[] stooges = new String[3];         
      //initialize array (assign values to each array element)
      stooges[0] = new String("Larry");
      stooges[1] = new String("Curley");
      stooges[2] = new String("Moe");
       //return array to calling method 
      return stooges;
   }
   
   /**
    * displays an array of Strings.
    * @param anArray the array to be displayed 
    */
   public static void displayArray(String[] anArray) {
     
      int lengthOfName = 0;
      int lengthOfArray = anArray.length; //not length()
      
      System.out.println("array length = " + lengthOfArray);
      
      for (int i = 0; i < lengthOfArray; i++) {
         //get length of the String held in array
         lengthOfName = anArray[i].length(); //not length
         
         System.out.println(anArray[i] + " has " 
             + lengthOfName + " characters");
      }
      //pass by reference, can change main array here!
      //anArray[0] = "Shemp"; 
   }
}
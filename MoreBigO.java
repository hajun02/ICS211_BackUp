/**
 * Timed Big-O examples.
 * (n is the 1st commandline argument) 
 * Input these numbers: 10, 100, 1000, 10000, etc. 
 * You will notice that it takes longer & longer 
 * for the program to run. And the loops
 * with a large Big-O will quickly increase 
 * their running time, as compared to those 
 * loops with a small Big-O.
 * 
 * @author William McDaniel Albritton
 */
public class MoreBigO {
   /**
    * Program starts here.
    * 
    * @param args 1st commandline arg should be a non-negative number
    */
   public static void main(String[] args) {
      // check for correct number of args (at least 1)
      if (args.length == 0) {
         System.out.print("Error: Enter at least 1 commandline argument ");
      }
      else {
         // initialize variables
         Long n = new Long(0);
         Long count = new Long(0);
         Long startTimeInMsec = new Long(0);
         Long totalTimeInMsec = new Long(0);
      
         // error checking to see if it is a long integer
         try {
            n = Long.parseLong(args[0]);
         }
         catch (NumberFormatException exception) {
            System.out.print(exception);
            System.out.println(" is not a long integer!");
            System.exit(1); // end program
         }
      
      /*
      Example 1: 
      Answer: O(1)
      Detailed explanation: 
      This for-loop repeats 10 times, so it is a constant. 
      Even if n is really large, the number of loops does not change.
      So this for-loop runs really fast!
      Therefore, the loop has a Big-O of O(1).
      */
         startTimeInMsec = System.currentTimeMillis();
         for (long i = 0; i < 10; i++) {
            count++;
         }
         totalTimeInMsec = System.currentTimeMillis() - startTimeInMsec;
         System.out.println("example 1: O(1)");
         System.out.println("count = " + count);
         System.out.println("time = " + totalTimeInMsec + " milliseconds" + "\n");
      
      /*
      Example 2:  
      Answer: O(log n)
      Detailed explanation: 
      This for-loop doubles its count with every loop. 
      In other words, i = 1, 2, 4, 8, 16, etc. 
      Whenever we see this kind of doubling (tripling, quadrupling, etc.), 
      then we know that the time it takes to complete the loop is 
      logarithmic time, which is quite fast. 
      This for-loop repeats log2(n) times (log base 2 times).
      For example, if you enter the number 10000000000000000, then 
      log2 (10000000000000000) = 53.15085, 
      so the loop repeats 54 times.
      Typically, we leave off the base for logarithms, 
      as we are only interested in an estimated time, not the exact time.
      Therefore, the loop has a Big-O of O(log n). 
      */
         count = new Long(0);
         startTimeInMsec = System.currentTimeMillis();
         for (long i = 1; i < n; i = i * 2) {
            count++;
         }
         totalTimeInMsec = System.currentTimeMillis() - startTimeInMsec;
         System.out.println("example 2: O(log n)");
         System.out.println("count = " + count);
         System.out.println("time = " + totalTimeInMsec + " milliseconds" + "\n");
      
      /*
      Example 3: 
      Answer: O(1) + O(log n) = O(log n) 
      Detailed explanation: 
      These are two separate loops, so we add the Big-O terms together.
      O(1) is much smaller (faster running) than O(log n). 
      In other words, the second loop of O(log n) will run much slower
      than the first loop of O(1), so we can just ignore the time it 
      takes the O(1) loop to repeat.
      If you enter the number 10000000000000000, you can see that the loop 
      repeats itself 64 (10 + 54) times.
      */
         count = new Long(0);
         startTimeInMsec = System.currentTimeMillis();
         for (long i = 0; i < 10; i++) {
            count++;
         }
         for (long i = 1; i < n; i = i * 2) {
            count++;
         }
         totalTimeInMsec = System.currentTimeMillis() - startTimeInMsec;
         System.out.println("example 3: O(log n)");
         System.out.println("count = " + count);
         System.out.println("time = " + totalTimeInMsec + " milliseconds" + "\n");
      
      /*
      Example 4: 
      Answer: O(1) * O(log n) = O(1*log n) = O(log n)
      Detailed explanation: 
      These are two nested loops, so we multiply the Big-O terms.
      Just like "regular" math, one times a number is the number.
      In other words, 1 * log(n) = log(n). 
      If you enter the number 10000000000000000, 
      you can see that the loop repeats itself 540 (10 * 54) times.
      */
         count = new Long(0);
         startTimeInMsec = System.currentTimeMillis();
         for (long i = 0; i < 10; i++) {
            for (long j = 1; j < n; j = j * 2) {
               count++;
            }
         }
         totalTimeInMsec = System.currentTimeMillis() - startTimeInMsec;
         System.out.println("example 4: O(log n)");
         System.out.println("count = " + count);
         System.out.println("time = " + totalTimeInMsec + " milliseconds" + "\n");
      
      /*
      Example 5: 
      Answer: O(n)
      Detailed explanation: 
      This loop repeats n number of times, so it is O(n). 
      If you enter the number 10000000000000000, 
      you will have to wait a long time! 
      This is because, it will loop 10000000000000000 times! 
      So enter a smaller number such as 100000000. 
      You will see that this loops many more times, 
      and so takes much longer time, than examples 1-4
      */
         count = new Long(0);
         startTimeInMsec = System.currentTimeMillis();
         for (long i = 0; i < n; i++) {
            count++;
         }
         totalTimeInMsec = System.currentTimeMillis() - startTimeInMsec;
         System.out.println("example 5: O(n)");
         System.out.println("count = " + count);
         System.out.println("time = " + totalTimeInMsec + " milliseconds" + "\n");
      
      /*
      Example 6:
      Answer: O(1) + O(log n) + O(n) = O(n)
      Detailed explanation: 
      These are two separate loops, so we add the Big-O terms together.
      The largest (slowest running) term is O(n).
      The O(n) loop takes so much more time than the other two loops of O(1) and O(log n), 
      that we can ignore the O(1) and O(log n) terms.
      For input 100000000, the count is 100000037, so this does not take so much longer than example 5, 
      which is also O(n).
      */
         count = new Long(0);
         startTimeInMsec = System.currentTimeMillis();
         for (long i = 0; i < 10; i++) {
            count++;
         }
         for (long i = 1; i < n; i = i * 2) {
            count++;
         }
         for (long i = 0; i < n; i++) {
            count++;
         }
         totalTimeInMsec = System.currentTimeMillis() - startTimeInMsec;
         System.out.println("example 6: O(n)");
         System.out.println("count = " + count);
         System.out.println("time = " + totalTimeInMsec + " milliseconds" + "\n");
      
      /*
      Example 7: 
      Answer: O(1) * O(log n) * O(n) = O(n * log n)
      Detailed explanation: 
      These are two nested loops, so we multiply the Big-O terms.
      Just like 1*x=x, O(1) is not included in the final result.
      For input 100000000, you might have to wait a long time, depending on the speed of your computer. 
      This makes sense, because O(n * log n) will take longer time to run than O(n).
      So you should change the input to a shorter number such as 1000000.
      You can see now that example 6 repeats 1000030 times, but example 7 repeats 200000000 times! 
      */
         count = new Long(0);
         startTimeInMsec = System.currentTimeMillis();
         for (long i = 0; i < 10; i++) {
            for (long j = 1; j < n; j = j * 2) {
               for (long k = 0; k < n; k++) {
                  count++;
               }
            }
         }
         totalTimeInMsec = System.currentTimeMillis() - startTimeInMsec;
         System.out.println("example 7: O(n * log n)");
         System.out.println("count = " + count);
         System.out.println("time = " + totalTimeInMsec + " milliseconds" + "\n");
      
      /*
      Example 8: 
      Answer: O(n) * O(n) = O(n * n) = O(n^2)
      Detailed explanation: 
      These are two nested loops, so we multiply the Big-O terms.
      Since O(n^2) takes longer than O(n * log n), you need to enter a smaller number such as 10000.
      If you compare example 8 to example 7, you will see that example 8 loops many more times than example 7.
      */
         count = new Long(0);
         startTimeInMsec = System.currentTimeMillis();
         for (long i = 0; i < n; i++) {
            for (long j = 1; j < n; j++) {
               count++;
            
            }
         }
         totalTimeInMsec = System.currentTimeMillis() - startTimeInMsec;
         System.out.println("example 8: O(n^2)");
         System.out.println("count = " + count);
         System.out.println("time = " + totalTimeInMsec + " milliseconds" + "\n");
      
      /*
      Example 9: 
      Answer: O(n) * O(n) * O(n) = O(n * n * n) = O(n^3)
      Detailed explanation: 
      These are three nested loops, so we multiply the Big-O terms.
      Since O(n^3) takes longer than O(n^2), you need to enter a smaller number such as 1000.
      Again, you will see that the larger Big-O terms take longer to execute than the smaller Big-O terms.
      */
         count = new Long(0);
         startTimeInMsec = System.currentTimeMillis();
         for (long i = 0; i < n; i++) {
            for (long j = 1; j < n; j++) {
               for (long k = 1; k < n; k++) {
                  count++;
               }
            }
         }
         totalTimeInMsec = System.currentTimeMillis() - startTimeInMsec;
         System.out.println("example 9: O(n^3)");
         System.out.println("count = " + count);
         System.out.println("time = " + totalTimeInMsec + " milliseconds" + "\n");
      
      /*
      Example 10: 
      Answer: O(2^n) 
      Detailed explanation: 
      This loop repeats 2^n (2 to the power of n) number of times.
      Again, you will see that the larger Big-O terms take longer to execute than the smaller Big-O terms.
      */
         count = new Long(0);
         startTimeInMsec = System.currentTimeMillis();
         for (long i = 0; i < Math.pow(2, n); i++) {
            count++;
         }
         totalTimeInMsec = System.currentTimeMillis() - startTimeInMsec;
         System.out.println("example 10: O(2^n)");
         System.out.println("count = " + count);
         System.out.println("time = " + totalTimeInMsec + " milliseconds" + "\n");
      
      }// end of else
   
   }// end of main

}// end of class

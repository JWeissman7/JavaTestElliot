import java.util.ArrayList;
package code;

public class OfflineExercises {

	public String doubleChar(String input) {
     int lengthInput = input.length();
     String answerString = ""; 
     
     for (int i = 0; i < lengthInput; i++) {
      answerString = answerString + input.substring(i, i + 1) + 
    		  input.substring(i, i + 1);
     }
		return answerString;
	}
	
	/*
	// A sandwich is two pieces of bread with something in between. 
	Return the
	// string that is between the first and last appearance of 
	"bread" in the
	// given string, or return the empty string "" if there are not
	two pieces
	// of bread. */

	// getSandwich("breadjambread") → "jam"
	// getSandwich("xxbreadjambreadyy") → "jam"
	// getSandwich("xxbreadyy") → ""

	public String getSandwich(String input) {
		int lengthSandwich = input.length();
		int firstBread = 0;
		int secondBread = 0;
		
		for (int i = 0; i < lengthSandwich - 4; i++) {
		 if (input.substring(i, i + 5).equals("bread")) {
		  firstBread = i; // only out of bounds if only one 
		  // slice of bread!		  
		  break;
	     }
		}
		
		for (int j = lengthSandwich - 1; j >=0; j--) {
		 if (input.substring(j - 4, j + 1).equals("bread")) {
		 secondBread = j - 4; // only out of bounds if only one 
		 // slice of bread!		  
	     break;
		 }
		}

		if (firstBread != secondBread && secondBread != firstBread + 5) {
		 return input.substring(firstBread + 5, secondBread);
		}
		else {
		 return "";	
		}
	}

	/* Given three ints, a b c, one of them is small, one 
	 * is medium and one is
	// large. Return true if the three values are evenly spaced,
	 *  so the
	// difference between small and medium is the same as the
	 *  difference between
	// medium and large.

	// evenlySpaced(2, 4, 6) → true
	// evenlySpaced(4, 6, 2) → true
	// evenlySpaced(4, 6, 3) → false
	
	 */

	public boolean evenlySpaced(int a, int b, int c) {
	 int small = 0;
	 int medium = 0;
	 int large = 0;
	 
	 if (a > b && a > c) {
	  large = a;
	  if (a > c) {
	   medium = a;
	   small = c;
	  }
	  else {
	   medium = c;
	   small = a;
	  }
	 }
	 
	 if (a < b && a < c) {
	  small = a;
	  if (b > c) {
	   large = b;
	   medium = c;
	  }
	  else {
	   large = c;
	   medium = b;
      }
	 }
	 
	 if (a < b && a > c) {
	  medium = a;
	  large = b;
	  small = c;
	 }
	 
	 if (a > b && a < c) {
	  medium = a;
	  large = c;
	  small = b;
	 }
	 
     if (large - medium == medium - small) {
      return true;	 
     }
     else {
      return false;
     }
	}

	/* Given a string and an int n, return a string made
	 *  of the first and last n
	// chars from the string. The string length will be at least n.

	// nTwice("Hello", 2) → "Helo"
	// nTwice("Chocolate", 3) → "Choate"
	// nTwice("Chocolate", 1) → "Ce"
	 * 
	 * */
	 

	public String nTwice(String input, int a) {
	 return input.substring(0, a) + 
			 input.substring(input.length() - a, input.length());
	}

	/* Given a string, return true if it ends in "ly".

	// endsLy("oddly") → true
	// endsLy("y") → false
	// endsLy("oddy") → false
	 
	 */

	public boolean endsly(String input) {
     if (input.length() >= 2 && input.substring(input.length() - 2, input.length()). 
    	 equals("ly")) {
      return true;    	 
     }
     else {
      return false;
     }
	}

	/* Given a string, return recursively a "cleaned" string 
	 * where adjacent
	// chars that are the same have been reduced to a single 
	 * char. So "yyzzza"
	// yields "yza".

	// stringClean("yyzzza") → "yza"
	// stringClean("abbbcdd") → "abcd"
	// stringClean("Hello") → "Helo"
	
	*/
	
	public String stringClean(String input) {
     String currentLetter = "";
     String previousLetter = "";
     String cleanedString = "";
     
     for (int i = 0; i < input.length(); i++) {
      currentLetter = input.substring(i, i + 1); 
      if (! (currentLetter.equals(previousLetter))) {
       cleanedString = cleanedString + currentLetter;
      }
      previousLetter = currentLetter;
	 }
    return cleanedString;
	}


	/* The fibonacci sequence is a famous bit of mathematics, 
	and it happens to
	// have a recursive definition. The first two values in the 
	sequence are 0
	// and 1 (essentially 2 base cases). Each subsequent value is
	the sum of the
	// previous two values, so the whole sequence is: 0, 1, 1, 2, 
	3, 5, 8, 13,
	// 21 and so on. Define a recursive fibonacci(n) method that
	returns the nth
	// fibonacci number, with n=0 representing the start of the sequence.

	// fibonacci(0) → 0
	// fibonacci(1) → 1
	// fibonacci(2) → 1
	*/

	public int fibonacci(int input) {
	 int previous2Fibonacci = 0;
	 int previous1Fibonacci = 1;
	 int currentFibonacci = 0;
	 int tempStore = 0;
	 
	 if (input == 0) {
      return 0;		 
	 }
	 else if (input == 1) {
      return 1;
	 }
	 else {
      for (int i = 2; i <= input; i++) {
       currentFibonacci = previous1Fibonacci + previous2Fibonacci;  
       tempStore = previous1Fibonacci;
       previous2Fibonacci = tempStore;
       previous1Fibonacci = currentFibonacci;
      }
	 }
	 return currentFibonacci;
	}


	/* We have a number of bunnies and each bunny has two big 
	 * floppy ears. We
	// want to compute the total number of ears across all the
	 *  bunnies
	// recursively (without loops or multiplication).
	//
	// bunnyEars(0)  0
	// bunnyEars(1)  2
	// bunnyEars(2)  4
	*/

	public int bunnyEars(int input) {
	 ArrayList earArray = new ArrayList<Integer>();
	 if (input == 0) {
	  return earArray.get(earArray.size()-1);	 
	 }
	 
	else {
	  numEars = numEars + 2;
	  bunnyEars(input - 1);
	  return numEars;	           
	 }
	}

}

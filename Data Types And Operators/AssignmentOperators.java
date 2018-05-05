package operators;
public class AssignmentOperators {
	public static void main(String[] args) {

		/*
		 * For Integer literals (int, long), the default is int. For obvious reasons.
		 * For Floating point literals (float, double) the default is double. Because using double potentially allows safer arithmetic on the stored values.
		 * So, when you type 12 in your program, thats an int literal, as opposed to 12L, which is a long. And when you type 12.3, thats a double literal, as opposed to 12.3F, which is a float.
		 */

		int x = 10;
		float y = 3.5F;
		String value = "Led Zeppelin FTW";
		System.out.println("x = "+x+"\ny = "+y+"\nvalue = "+value);

		/* Assigning int with float value. Is this possible? uncomment to see
		x = 1.2232; 
		System.out.println("\nAfter assigning int x with a float value, x = "+x);
		*/

		// Basic arithemetic
		x = 5/2;
		System.out.println("\nAfter assigning int x with result of 5/2, x = "+x);

		x = 5/2;
		System.out.println("\nAfter assigning int x with result of 5/2 and printing type casted value, (float)x = "+(float)x);
		
		y = 5/2;
		System.out.println("\nAfter assigning float y with result of 5/2, y = "+y);

		y = 5/2;
		System.out.println("\nAfter assigning float y with result of 5/2 and printing type casted value, (int)y = "+(int)y);

		/* is this possible? uncomment to see
		y = 5.0/2.0;
		System.out.printf("\nAfter assigning float y with result of 5.0/2.0, y = "+y);
		*/
	
		y = 5.0F/2.0F;
		System.out.println("\nAfter assigning float y with result of 5.0F/2.0F, y = "+y);
		
	}	
}

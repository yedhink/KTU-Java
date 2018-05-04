package loops;
/* A program to find average of nos 1,4,2,6,7
 * Using For Each loops
 * */

class Foreach 
{
	public static void main(String args[]){
		int sum=0,av;
		int avg [] = {1,4,2,6,7};
		for(int i : avg){
			sum +=i;

		}
		av = sum/avg.length;
		System.out.println("Average is "+av);

	}
}

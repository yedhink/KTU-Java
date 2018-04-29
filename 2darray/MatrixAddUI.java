package twoDArray;
import java.util.Scanner;
class MatrixAddUI{
	public static void main(String args[]){
		int Mat1[][]=new int[10][10];
		int Mat2[][]=new int[10][10];
		int res[][]=new int[10][10];
		int i=0 , j=0 ;
		Scanner Cin = new Scanner(System.in);
		System.out.printf("Enter the number of rows = ");
		int r = Cin.nextInt();
		System.out.printf("Enter the number of coloumn = ");
		int c = Cin.nextInt();
		
		System.out.println("Enter First Matrix: ");
		for(i=0;i<r;i++){
			for(j=0;j<c;j++){
				System.out.printf("Enter the element Matrix1[%d][%d] = ",i,j);
				Mat1[i][j]=Cin.nextInt();
			}
			System.out.println();
		}

		System.out.println("\nEnter Second Matrix");
		for(i=0;i<r;i++){
			for(j=0;j<c;j++){
				System.out.printf("Enter the element Matrix2[%d][%d] = ",i,j);
				Mat2[i][j]=Cin.nextInt();
			}
			System.out.println();
		}

		System.out.println("\nFirst Matrix:");
		for(i=0;i<r;i++){
			for(j=0;j<c;j++){
				System.out.print(Mat1[i][j] + " ");
			}
			System.out.println();
		}

		System.out.println("\nSecond Matrix:");
		for(i=0;i<r;i++){
			for(j=0;j<c;j++){
				System.out.print(Mat2[i][j] + " ");
			}
			System.out.println();
		}

		// Adding both matrices
		for(i=0;i<r;i++)
			for(j=0;j<c;j++){
				res[i][j]=Mat1[i][j]+Mat2[i][j];
			}

		System.out.println("\nResultant Matrix:");
		for(i=0;i<r;i++){
			for(j=0;j<c;j++)
				System.out.print(res[i][j] + " ");
			System.out.println();
		}

	}
}

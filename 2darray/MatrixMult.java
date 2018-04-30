package twoDArray;
import java.util.Scanner;
class MatrixMult{
	public static void main(String args[]){
		int Mat1[][]=new int[10][10];
		int Mat2[][]=new int[10][10];
		int res[][]=new int[10][10];
		int i=0;
		int j=0;
		Scanner Cin = new Scanner(System.in);
		System.out.printf("Enter the number of rows of matrix 1 = ");
		int r1 = Cin.nextInt();
		System.out.printf("Enter the number of column of matrix 1 = ");
		int c1 = Cin.nextInt();

		System.out.println("\nEnter First Matrix");
		for(i=0;i<r1;i++){
			for(j=0;j<c1;j++){
				System.out.printf("Enter the element Matrix1[%d][%d] = ",i,j);
				Mat1[i][j]=Cin.nextInt();
			}
			System.out.println();
		}

		System.out.printf("\nEnter the number of rows of matrix 2 = ");
		int r2 = Cin.nextInt();
		System.out.printf("Enter the number of column of matrix 2 = ");
		int c2 = Cin.nextInt();
		System.out.println("\nEnter Second Matrix");
		for(i=0;i<r2;i++){
			for(j=0;j<c2;j++){
				System.out.printf("Enter the element Matrix1[%d][%d] = ",i,j);
				Mat2[i][j]=Cin.nextInt();
			}
			System.out.println();
		}
		
		// Number of columns of 1st matrix should be equal to no of rows of 2nd to multiply
		if(c1!=r2){
			System.out.println("operation not possible");
			System.exit(0);
		}
		else{ // if the condition is satisfied we multiply
			for(i=0;i<r1;i++){
				for(j=0;j<c2;j++){
					res[i][j]=0;
					for(int k=0;k<c1;k++){
						res[i][j]=res[i][j]+Mat1[i][k]*Mat2[k][j];
					}
				}
			}
		}

		System.out.println("\nFirst Matrix:");
		for(i=0;i<r1;i++){
			for(j=0;j<c1;j++){
				System.out.print(Mat1[i][j] + "\t");
			}
			System.out.println();
		}

		System.out.println("\nSecond Matrix:");
		for(i=0;i<r2;i++){
			for(j=0;j<c2;j++){
				System.out.print(Mat2[i][j] + "\t");
			}
			System.out.println();
		}

		System.out.println("\nResultant Matrix:");
		for(i=0;i<r1;i++){
			for(j=0;j<c2;j++)
				System.out.print(res[i][j] + "\t");
			System.out.println();
		}

	}
}

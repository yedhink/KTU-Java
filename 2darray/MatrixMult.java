import java.util.Scanner;
class MatrixMult{
public static void main(String args[]){
		int Mat1[][]=new int[10][10];
		int Mat2[][]=new int[10][10];		
		int res[][]=new int[10][10];		
		int i=0;
		int j=0;
		Scanner Cin = new Scanner(System.in);
		System.out.printf("Enter the number of rows of matrix 1");
		int r1 = Cin.nextInt();
		System.out.printf("Enter the number of coloumn of matrix 1");
		int c1 = Cin.nextInt();
		System.out.println("First Matrix");		
		for(i=0;i<r1;i++)
			for(j=0;j<c1;j++){
				System.out.printf("Enter the elements");
				int k =Cin.nextInt();
				Mat1[i][j]=k;
			}
		System.out.printf("Enter the number of rows of matrix 2");
		int r2 = Cin.nextInt();
		System.out.printf("Enter the number of coloumn of matrix 2");
		int c2 = Cin.nextInt();
		System.out.println("Second Matrix");
		for(i=0;i<r2;i++)
			for(j=0;j<c2;j++){
				System.out.printf("Enter the elements");
				int l =Cin.nextInt();
				Mat2[i][j]=l;
			}
		if(r1!=c2){
			System.out.println("operation not possible");
			System.exit(0);
			}
		else{
			for(i=0;i<r1;i++){
				for(j=0;j<c2;j++){
					res[i][j]=0;
					for(int k=0;k<c1;k++){
						res[i][j]=res[i][j]+Mat1[i][k]*Mat2[k][j];
						}
					}
				}
		}
		System.out.println("Resultant Matrix:");
		for(i=0;i<r1;i++){
			for(j=0;j<c2;j++)
				System.out.print(res[i][j] + " ");
			System.out.println();
			}
		
}
}

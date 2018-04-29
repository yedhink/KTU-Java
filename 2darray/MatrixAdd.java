class MatrixAdd{
	public static void main(String args[]){
		int Mat1[][]=new int[4][4];
		int Mat2[][]=new int[4][4];		
		int res[][]=new int[4][4];		
		int i=0;
		int j=0;
		int k=0;
		int l=0;

		for(i=0;i<4;i++)
			for(j=0;j<4;j++){
				Mat1[i][j]=k;
				k++;
			}
		for(i=0;i<4;i++)
			for(j=0;j<4;j++){
				Mat2[i][j]=l;
				l++;
			}
		for(i=0;i<4;i++)
			for(j=0;j<4;j++){
				res[i][j]=Mat1[i][j]+Mat2[i][j];
				}
		

		
		for(i=0;i<4;i++){
			for(j=0;j<4;j++)
				System.out.print(res[i][j] + " ");
			System.out.println();
			}
		
}
}

class Matrix{
	public static void main(String args[]){
		int Mat[][]=new int[4][4];
		int i=0;
		int j=0;
		int k=0;
		for(i=0;i<4;i++)
			for(j=0;j<4;j++){
				Mat[i][j]=k;
				k++;
			}
		
		for(i=0;i<4;i++){
			for(j=0;j<4;j++)
				System.out.print(Mat[i][j] + " ");
			System.out.println();
			}
		
}
}

package leetcode;


class Run{
	public static void main(String args[]){
		Solution test = new Solution();
		int[][] matrix = {{3,3,3},{2,2,2},{1,1,1}};
		
		for(int i = 0; i < matrix.length; i ++){
        	for(int j =0; j < matrix.length; j ++){
        		System.out.print(matrix[i][j]);
        	}
        	System.out.println();
        }
		
		test.rotate(matrix);
		
        for(int i = 0; i < matrix.length; i ++){
        	for(int j =0; j < matrix.length; j ++){
        		System.out.print(matrix[i][j]);
        	}
        	System.out.println();
        }
	}
}



public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix[0].length;
        int[][] temp = new int[n][n];
        
        if(n == 1)
        	matrix = matrix;
        for(int i = 0; i < n; i ++){
        	for(int j =0; j < n; j ++){
        		temp[i][j] = matrix[n-1-j][i];
        	}
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                matrix[i][j] = temp[i][j];
            }
        } 

    }
}
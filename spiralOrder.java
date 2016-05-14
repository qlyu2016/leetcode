class Run{
	public static void main(String args[]){
		Solution test = new Solution();
 
        int[][] matrix = {
        		
        };

        
        List<Integer> result = test.spiralOrder(matrix);
        for(int i = 0; i < result.size(); i ++){
            System.out.print(result.get(i));
        }

	}
}

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if(matrix.length == 0)
        	return result;
        
        int row = matrix.length;
        int col = matrix[0].length;
        if(col == 0)
        	return result;
        
        if(row == 1){
        	for(int i = 0; i < col; i ++){
        		result.add(matrix[0][i]);
        	}
        	return result;
        }
        
        if(col == 1){
        	for(int i = 0; i < row; i ++){
        		result.add(matrix[i][0]);
        	}
        	return result;
        }
        
        for(int i = 0; i < col; i ++){
        	result.add(matrix[0][i]);
        }
        
        for(int i = 1; i < row - 1; i ++){
        	result.add(matrix[i][col - 1]);
        }
        
        for(int i = col - 1; i >= 0; i --){
        	result.add(matrix[row - 1][i]);
        }
        
        for(int i = row - 2; i >= 1; i --){
        	result.add(matrix[i][0]);
        }

        int[][] subMatrix = new int[row - 2][col - 2];
        for(int i = 1; i < row - 1; i ++){
        	for(int j = 1; j < col - 1; j ++){
        		subMatrix[i - 1][j - 1] = matrix[i][j];
        	}
        }
        
        List<Integer> temp = spiralOrder(subMatrix);
        
        result.addAll(temp);
        
        return result;
    }
}
import java.util.ArrayList;

public class Solution {
    private int num = 1;
    private int[][] array;
        
    public int[] solution(int n) {
        array = new int[n][n];
        
        countingNum(0, 0, n);
        
        ArrayList<Integer> resultList = new ArrayList();
        for(int row = 0; row < n; row++)
            for(int col = 0; col < n; col++)
                if(array[row][col] != 0)
                    resultList.add(array[row][col]);
        
        int count = resultList.size();
        int[] answer = new int[count];
        for(int index = 0; index < count; index++){
            answer[index] = resultList.get(index);
        }   
        return answer;
    }
    
    private void countingNum(int row, int col, int max) {
    	int curRow = row;
    	int curCol = col;
    	
    	for(int r = curRow; r < max; r++) {
    		if(array[r][col] != 0)
        		break;
    		
    		array[r][col] = num++;
    		curRow = r;
    	}
        
        for(int c = col+1; c < max; c++) {
        	if(array[curRow][c] != 0)
        		break;
        	
            array[curRow][c] = num++;
            curCol = c;
        }
     
        while(curRow > row && curCol > col) {
        	curRow--;
            curCol--;
            
            if(array[curRow][curCol] != 0)
           	    break;
            
        	array[curRow][curCol] = num++;   
        	
            if(curRow-1 == row && curCol-1 == col) {
                countingNum(curRow+1, curCol, max-1);
                break;
            }
        }        
    }
}

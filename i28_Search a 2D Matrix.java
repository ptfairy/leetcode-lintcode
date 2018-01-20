// Binary search once
public class Solution {
    /*
     * @param matrix: matrix, a list of lists of integers
     * @param target: An integer
     * @return: a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        } 
        
        int row = matrix.length;
        int column = matrix[0].length;
        
        int start = 0, end = row * column -1;
        while (start + 1 <  end) {
            int mid  = start + (end - start)/2;
            int number = matrix[mid / column][mid % column];
            if (number == target){
                return true;
            }else if(number > target){
                end = mid;
            }else{
                start = mid;
            }
            
            if (matrix[end / column][end % column] == target) {
                return true;
            }
            
            if (matrix[start / column][start % column] == target) {
                return true;
            }
            
        }
        return false;
    }
}

// Binary search twice
public class Solution {
    /*
     * @param matrix: matrix, a list of lists of integers
     * @param target: An integer
     * @return: a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        } 
        
        int row = matrix.length;
        int column = matrix[0].length;
        
        int start = 0, end = row -1;
        while (start + 1 < end) {
            int mid = start + (end - start)/ 2;
            if (matrix[mid][0] == target) {
                return true;
            }
            if (matrix[mid][0] < target) {
                start = mid;
            }
            if (matrix[mid][0] > target) {
                end = mid;
            }
        }
        if (matrix[end][0] <= target) {
            row = end;
        } else if (matrix[start][0] <= target) {
            row = start;
        } else {
            return false;
        }
        
        
        start = 0;
        end = column -1;
        while (start + 1 < end) {
            int mid = start + (end - start)/2;
            if (matrix[row][mid] == target) {
                return true;
            }
            if (matrix[row][mid] < target) {
                start = mid;
            }
            if (matrix[row][mid] > target) {
                end = mid;
            }
        }
        if (matrix[row][start] == target) {
            return true;
        }
        if (matrix[row][end] == target) {
            return true;
        }
        return false;
    }
}
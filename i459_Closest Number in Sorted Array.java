// O(n)
public class Solution {
    /*
     * @param A: an integer array sorted in ascending order
     * @param target: An integer
     * @return: an integer
     */
    public int closestNumber(int[] A, int target) {
        // write your code here
        List<Integer> distance = new ArrayList<Integer>();
        for (int i = 0; i < A.length; i++) {
            distance.add(Math.abs(A[i] - target));
        }
        int minIndex = distance.indexOf(Collections.min(distance));
        return minIndex;
    }    
}

// O(logn)
public class Solution {
    /*
     * @param A: an integer array sorted in ascending order
     * @param target: An integer
     * @return: an integer
     */
    public int closestNumber(int[] A, int target) {
        // write your code here
        int start = 0, end = A.length - 1;
        if (A.length == 0 || A == null) {
            return -1;
        }
        // start + 1 < end 即循环结束时start和end相邻
        while (start + 1 < end) {
            int mid = start + (start + end) / 2;
            if (A[mid] == target) {
                return mid;
            }
            if (A[mid] > target) {
                end = mid;
            }
            if (A[mid] < target) {
                start = mid;
            }
        } 
        if (target <= A[start]) {
            return start;
        }else if (A[end] <= target) {
            return end;
        } else {
            if (A[end] - target > target - A[start]) {
                return start;
            } else {
                return end;
            }
        }
    }    
}
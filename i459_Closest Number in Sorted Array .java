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
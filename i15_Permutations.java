// recursive1
public class Solution {
    /*
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public List<List<Integer>> permute(int[] nums) {
        // 左边是变量的声明，右边是初始化
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if (nums == null) {
            return results;
        }
        // 在 if (subset.size() == nums.length) 中考虑了num.length = 0 的情况
        /* if (nums.length == 0) {
            results.add(new ArrayList<Integer>());
            return results;
        } */

        helper(nums, new ArrayList<Integer>(), results);
        return results;
    }
    
    private void helper (int[] nums, ArrayList<Integer> subset, List<List<Integer>> results ) {
        if (subset.size() == nums.length) {
            results.add(new ArrayList<Integer>(subset));
            System.out.println("results" + results);
        } else {
            for (int i = 0; i < nums.length; i++) {
                if(subset.contains(nums[i])) {
                    continue;
                }
                subset.add(nums[i]);
                System.out.println("subset" + subset);
                helper(nums, subset, results);
                subset.remove(subset.size() - 1);
                System.out.println("subset removed" + subset);
            }
        }
    }
}

// recursive2
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null) {
            return results;
        }
        
        if (nums.length == 0) {
            return results;
        }
        helper(nums, 0, new ArrayList<>(), results);
        return results;
    }
    
    private void helper(int[] nums, int startIndex, List<Integer> subset, List<List<Integer>> results) {
        if (subset.size() == nums.length) {
            results.add(subset);
            // 每有一个permutation加入results则跳出到上一层从其他位置插入，backtacking的本质是DFS
            return;
        }
        //这里约束为subset的size决定插入新数的位置，注意为等号
        for (int i = 0; i <= subset.size(); i++) {
            List<Integer> newsubset = new ArrayList<>(subset);
            newsubset.add(i, nums[startIndex]);
            helper(nums, startIndex + 1, newsubset, results);
        }
    } 
}
package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Questions {
    // Approach
    // 1.	Sort the array.
    // 2.	Fix the first element using loop i.
    // 3.	Skip duplicates for the first element.
    // 4.	Fix the second element using loop j (inside 3Sum logic).
    // 5.	Skip duplicates for the second element.
    // 6.	Use two pointers left and right for the remaining two elements.
    // 7.	Calculate the sum = nums[i] + nums[j] + nums[left] + nums[right].
    // 8.	If sum == target → store quadruplet and move both pointers.
    // 9.	If sum < target → move left++ to increase sum.
    // 10.	If sum > target → move right-- to decrease sum.
    // 11.	Skip duplicates for left and right.
    // 12.	Continue until all unique quadruplets are found.
    // 13.	Return the result list.


    // Two Sum
    public static void twoSum(int[] nums, int start, int target, int first, int second, List<List<Integer>> res) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                res.add(Arrays.asList(first, second, nums[left], nums[right]));
                while (left < right && nums[left] == nums[left + 1]) left++;
                while (left < right && nums[right] == nums[right - 1]) right--;
                left++;
                right--;
            } else if (sum < target) left++;
            else right--;
        }
    }

    // Three Sum
    public static void threeSum(int[] nums, int start, int target, int first, List<List<Integer>> res) {
        int n = nums.length;
        for (int i = start; i < n - 2; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue; // skip duplicates
            int second = nums[i];
            twoSum(nums, i + 1, target - second, first, second, res);
        }
    }
        public List<List<Integer>> fourSum(int[] nums, int target) {
            int n = nums.length;
            Arrays.sort(nums);
            List<List<Integer>> res = new ArrayList<>();
            if(n<4) return new ArrayList<>();
            for(int i = 0;i<n-3;i++){
                if(i>0 && nums[i]==nums[i-1]) continue;
                int first = nums[i];
                threeSum(nums,i+1,target-first,first,res);
            }
            return res;

        }
    }



import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSumAndDoubleCombination {
    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 2, -4, -6, -2, 8};
        int target = 4;

        List<int[]> firstCombination = findTwoSum(nums, target);
        System.out.println("First Combination for \"" + target + "\":");
        for (int[] pair : firstCombination) {
            System.out.println(Arrays.toString(pair));
        }

        int[] mergedArray = mergeArray(nums);
        System.out.println("Merged Array:");
        System.out.println(Arrays.toString(mergedArray));

        int doubleTarget = target * 2;
        List<int[]> secondCombination = findTwoSum(mergedArray, doubleTarget);
        System.out.println("Second Combination for \"" + doubleTarget + "\":");
        for (int[] pair : secondCombination) {
            System.out.println(Arrays.toString(pair));
        }
    }

    private static List<int[]> findTwoSum(int[] nums, int target) {
        List<int[]> result = new ArrayList<>();
        Map<Integer, Integer> numToIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (numToIndex.containsKey(complement)) {
                int[] pair = {nums[i], complement};
                result.add(pair);
            }
            numToIndex.put(nums[i], i);
        }

        return result;
    }

    private static int[] mergeArray(int[] nums) {
        int[] merged = new int[nums.length];
        System.arraycopy(nums, 0, merged, 0, nums.length);
        Arrays.sort(merged);
        return merged;
    }
}
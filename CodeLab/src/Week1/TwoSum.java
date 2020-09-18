package Week1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/*
Two Sum Problem: Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 */
public class TwoSum {
    private static int[] twoSum(int[] array, int k) {
        // assume that there is always one solution
        int[] result = new int[2];
        Map<Integer, Integer> hmap = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (hmap.get(array[i]) != null){
                result[0] = i;
                result[1] = hmap.get(array[i]);
                return result;
            }
            hmap.put(k-array[i], i);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{}, 10)));
        System.out.println(Arrays.toString(twoSum(new int[]{3,4,5,6}, 10)));
        System.out.println(Arrays.toString(twoSum(new int[]{3,4,5,5,6}, 10)));
    }
}

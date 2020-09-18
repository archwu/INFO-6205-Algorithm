package Week1;

import java.util.HashMap;
import java.util.Map;

/*
Check Permutation: Given two strings, write a method to decide if one is a permutation of the other
 */
public class CheckPermutation {
    private static boolean isPermutation(String a, String b){
        if (a.length() != b.length()) return false;
        Map<Character, Integer> map_a = new HashMap<>();
        Map<Character, Integer> map_b = new HashMap<>();
        for (char c : a.toCharArray()) {
            if (map_a.putIfAbsent(c, 0) != null){
                map_a.put(c, map_a.get(c) + 1);
            }
        }
        for (char c : b.toCharArray()) {
            if (map_b.putIfAbsent(c, 0) != null){
                map_b.put(c, map_b.get(c) + 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : map_a.entrySet()){
            if (map_b.get(entry.getKey()) == null || !map_b.get(entry.getKey()).equals(entry.getValue())){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPermutation("abc","cba"));
        System.out.println(isPermutation("abc","cbv"));
        System.out.println(isPermutation("abc","cbaa"));
        System.out.println(isPermutation("abcc","cbaa"));
    }
}

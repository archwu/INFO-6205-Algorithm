package Week1;

import java.util.HashSet;
import java.util.Set;

/*
Is Unique: Implement an algorithm to determine if a string has all unique characters.
 */
public class AllUniqueString {
    private static boolean isAllUnique(String input) {
        if (input == null || input.length() == 0) return true;
        Set<Character> hashSet = new HashSet<>();
        for (char c: input.toCharArray()){
            if (!hashSet.add(c)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAllUnique("this is not unique"));
        System.out.println(isAllUnique("uniqe  "));
    }
}

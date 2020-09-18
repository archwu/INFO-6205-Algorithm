package Week1;

/*
Rotate and array: Given an array, rotate the array to the right by k steps, where k is non-negative.
 */
public class RotateArray {
    public static char[] rotateArray(char[] chars, int k) {
        if (chars == null || chars.length ==  0) return chars;
        int steps = k % chars.length;
        char[] mirror = chars.clone();
        for (int i = 0; i < chars.length; i++) {
            chars[(i + steps) % chars.length] = mirror[i];
        }
        return chars;
    }

    public static void main(String[] args) {
        System.out.println(rotateArray("abcdefg".toCharArray(), 10));
        System.out.println(rotateArray("abcdefg".toCharArray(), 3));
        System.out.println(rotateArray("abcd".toCharArray(), 1));
    }
}

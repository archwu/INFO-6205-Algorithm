package Week1;

/*
Sum of two Strings: Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
 */
public class SumOfTwoStr {
    public static String sumOfTwo(String a, String b) {
        // convert strings to char arrays
        char[] x = a.toCharArray();
        char[] y = b.toCharArray();
        // StringBuilder to hold sum of digit
        StringBuilder sb = new StringBuilder();
        int ind_x = x.length - 1;
        int ind_y = y.length - 1;
        int carry = 0;
        while (ind_x >= 0 || ind_y >= 0) {
            carry += (ind_x >= 0) ? x[ind_x] - '0' : 0;
            carry += (ind_y >= 0) ? y[ind_y] - '0' : 0;
            sb.append(carry % 10);
            carry /= 10;
            ind_x--;
            ind_y--;
        }

        if (carry != 0) sb.append(carry);

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(sumOfTwo("111", "99"));
        System.out.println(sumOfTwo("1000000000000", "999999999999"));
        System.out.println(sumOfTwo("1", "99"));
        System.out.println(sumOfTwo("", "5"));
    }
}
